package com.interview.bnpl.service;

import com.interview.bnpl.domain.*;
import com.interview.bnpl.exception.InsufficientCreditException;
import com.interview.bnpl.factory.RepaymentPlanFactory;
import com.interview.bnpl.gateway.*;
import com.interview.bnpl.repository.*;
import java.time.LocalDate;
import java.util.Optional;

public class BNPLServiceImpl implements BNPLService {
    private final CreditAccountRepository creditAccounts;
    private final LoanRepository loans;
    private final PaymentRepository payments;
    private final PaymentGateway paymentGateway;

    public BNPLServiceImpl(CreditAccountRepository creditAccounts, LoanRepository loans,
                           PaymentRepository payments, PaymentGateway paymentGateway) {
        this.creditAccounts = creditAccounts;
        this.loans = loans;
        this.payments = payments;
        this.paymentGateway = paymentGateway;
    }

    public Money checkAvailableCredit(String customerId) {
        return creditAccounts.findByCustomerId(customerId).availableCredit();
    }

    public synchronized Loan purchase(String customerId, String orderId, Money amount,
                                      String idempotencyKey, RepaymentPlanType planType) {
        Optional<Loan> existing = loans.findByOrderId(orderId);
        if (existing.isPresent()) return existing.get();

        CreditAccount account = creditAccounts.findByCustomerId(customerId);
        if (!account.reserveCredit(amount)) throw new InsufficientCreditException("Insufficient BNPL credit");

        boolean confirmed = false;
        try {
            var strategy = RepaymentPlanFactory.getStrategy(planType);
            var installments = strategy.createPlan(amount, LocalDate.now());
            Loan loan = new Loan(customerId, orderId, amount, installments);
            loan.activate();
            account.confirmReservation(amount);
            loans.save(loan);
            creditAccounts.save(account);
            confirmed = true;
            return loan;
        } finally {
            if (!confirmed) account.releaseCredit(amount);
        }
    }

    public synchronized Payment repay(String loanId, Money amount, String idempotencyKey) {
        Optional<Payment> previous = payments.findByIdempotencyKey(idempotencyKey);
        if (previous.isPresent()) return previous.get();

        Loan loan = loans.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found: " + loanId));
        if (amount.isZero() || amount.isGreaterThan(loan.getOutstanding()))
            throw new IllegalArgumentException("Invalid repayment amount");

        Payment payment = new Payment(loanId, idempotencyKey, amount);
        payments.save(payment);

        PaymentResult result = paymentGateway.charge(amount, idempotencyKey);
        if (result.status() == PaymentResult.Status.UNKNOWN) {
            // Keep pending for reconciliation; do not apply balance changes.
            return payment;
        }
        if (result.status() == PaymentResult.Status.FAILED) {
            payment.markFailed();
            return payment;
        }

        payment.markSuccess(result.providerReference());
        loan.applyRepayment(amount);
        CreditAccount account = creditAccounts.findByCustomerId(loan.getCustomerId());
        account.applyRepayment(amount);
        loans.save(loan);
        creditAccounts.save(account);
        return payment;
    }
}
