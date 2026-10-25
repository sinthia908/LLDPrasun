package com.interview.bnpl.domain;

import com.interview.bnpl.state.CreatedLoanState;
import com.interview.bnpl.state.LoanState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Loan {
    private final String loanId;
    private final String customerId;
    private final String orderId;
    private final Money principal;
    private final List<Installment> installments;
    private LoanState state = new CreatedLoanState();

    public Loan(String customerId, String orderId, Money principal, List<Installment> installments) {
        this.loanId = java.util.UUID.randomUUID().toString();
        this.customerId = customerId;
        this.orderId = orderId;
        this.principal = principal;
        this.installments = new ArrayList<>(installments);
    }
    public void activate() { state.activate(this); }
    public void markPaidOff() { state.markPaidOff(this); }
    public void setState(LoanState state) { this.state = state; }
    public String getLoanId() { return loanId; }
    public String getCustomerId() { return customerId; }
    public String getOrderId() { return orderId; }
    public Money getPrincipal() { return principal; }
    public List<Installment> getInstallments() { return Collections.unmodifiableList(installments); }
    public String getStatus() { return state.name(); }
    public synchronized Money getOutstanding() {
        Money total = new Money(java.math.BigDecimal.ZERO, principal.currency());
        for (Installment installment : installments) total = total.add(installment.getRemaining());
        return total;
    }
    public synchronized Money applyRepayment(Money amount) {
        if (!"ACTIVE".equals(state.name())) throw new IllegalStateException("Loan is not active");
        if (amount.isZero() || amount.isGreaterThan(get`Outstanding()))
            throw new IllegalArgumentException("Repayment must be positive and not exceed outstanding");
        Money remaining = amount;
        for (Installment installment : installments) {
            if (remaining.isZero()) break;
            remaining = installment.applyPayment(remaining);
        }
        if (getOutstanding().isZero()) markPaidOff();
        return amount;
    }
}
