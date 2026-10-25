package com.interview.bnpl.app;

import com.interview.bnpl.domain.*;
import com.interview.bnpl.gateway.MockPaymentGateway;
import com.interview.bnpl.repository.impl.*;
import com.interview.bnpl.service.*;

public class BNPLApplication {
    public static void main(String[] args) {
        var creditRepo = new InMemoryCreditAccountRepository();
        var loanRepo = new InMemoryLoanRepository();
        var paymentRepo = new InMemoryPaymentRepository();

        creditRepo.save(new CreditAccount("C101", Money.inr("50000.00")));

        BNPLService service = new BNPLServiceImpl(
                creditRepo, loanRepo, paymentRepo, new MockPaymentGateway());

        System.out.println("Available credit: " + service.checkAvailableCredit("C101"));

        Loan loan = service.purchase(
                "C101", "ORDER-501", Money.inr("15000.00"),
                "checkout-ORDER-501", RepaymentPlanType.THREE_INSTALLMENTS);

        System.out.println("Loan ID: " + loan.getLoanId());
        System.out.println("Loan status: " + loan.getStatus());
        System.out.println("Outstanding: " + loan.getOutstanding());

        Payment payment = service.repay(
                loan.getLoanId(), Money.inr("5000.00"), "repay-001");

        System.out.println("Payment status: " + payment.getStatus());
        System.out.println("Outstanding after repayment: " + loan.getOutstanding());
        System.out.println("Available credit: " + service.checkAvailableCredit("C101"));
    }
}
