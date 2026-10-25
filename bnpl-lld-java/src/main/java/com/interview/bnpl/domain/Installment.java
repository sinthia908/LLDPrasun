package com.interview.bnpl.domain;

import java.time.LocalDate;

public class Installment {
    private final String installmentId;
    private final Money amountDue;
    private final LocalDate dueDate;
    private Money amountPaid;
    private InstallmentStatus status = InstallmentStatus.PENDING;

    public Installment(Money amountDue, LocalDate dueDate) {
        this.installmentId = java.util.UUID.randomUUID().toString();
        this.amountDue = amountDue;
        this.dueDate = dueDate;
        this.amountPaid = new Money(java.math.BigDecimal.ZERO, amountDue.currency());
    }
    public synchronized Money applyPayment(Money payment) {
        if (payment.isZero()) throw new IllegalArgumentException("Payment must be positive");
        Money remaining = amountDue.subtract(amountPaid);
        Money applied = payment.isGreaterThan(remaining) ? remaining : payment;
        amountPaid = amountPaid.add(applied);
        status = amountPaid.amount().compareTo(amountDue.amount()) == 0
                ? InstallmentStatus.PAID : InstallmentStatus.PARTIALLY_PAID;
        return payment.subtract(applied);
    }
    public String getInstallmentId() { return installmentId; }
    public Money getAmountDue() { return amountDue; }
    public LocalDate getDueDate() { return dueDate; }
    public synchronized Money getAmountPaid() { return amountPaid; }
    public synchronized InstallmentStatus getStatus() { return status; }
    public synchronized Money getRemaining() { return amountDue.subtract(amountPaid); }
}
