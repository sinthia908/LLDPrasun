package com.interview.bnpl.domain;

public class CreditAccount {
    private final String customerId;
    private final Money creditLimit;
    private Money outstandingAmount;
    private Money reservedAmount;

    public CreditAccount(String customerId, Money creditLimit) {
        this.customerId = customerId;
        this.creditLimit = creditLimit;
        this.outstandingAmount = Money.inr("0.00");
        this.reservedAmount = Money.inr("0.00");
    }
    public synchronized boolean reserveCredit(Money amount) {
        Money available = creditLimit.subtract(outstandingAmount).subtract(reservedAmount);
        if (available.amount().compareTo(amount.amount()) < 0) return false;
        reservedAmount = reservedAmount.add(amount);
        return true;
    }
    public synchronized void confirmReservation(Money amount) {
        reservedAmount = reservedAmount.subtract(amount);
        outstandingAmount = outstandingAmount.add(amount);
    }
    public synchronized void releaseCredit(Money amount) {
        reservedAmount = reservedAmount.subtract(amount);
    }
    public synchronized void applyRepayment(Money amount) {
        outstandingAmount = outstandingAmount.subtract(amount);
    }
    public synchronized Money availableCredit() {
        return creditLimit.subtract(outstandingAmount).subtract(reservedAmount);
    }
    public String getCustomerId() { return customerId; }
    public Money getCreditLimit() { return creditLimit; }
    public synchronized Money getOutstandingAmount() { return outstandingAmount; }
    public synchronized Money getReservedAmount() { return reservedAmount; }
}
