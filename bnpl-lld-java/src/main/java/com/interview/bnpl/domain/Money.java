package com.interview.bnpl.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Objects;

public record Money(BigDecimal amount, Currency currency) {
    public Money {
        Objects.requireNonNull(amount);
        Objects.requireNonNull(currency);
        amount = amount.setScale(2, RoundingMode.HALF_UP);
        if (amount.signum() < 0) throw new IllegalArgumentException("Amount cannot be negative");
    }
    public static Money inr(String amount) {
        return new Money(new BigDecimal(amount), Currency.getInstance("INR"));
    }
    public Money add(Money other) { checkCurrency(other); return new Money(amount.add(other.amount), currency); }
    public Money subtract(Money other) {
        checkCurrency(other);
        BigDecimal result = amount.subtract(other.amount);
        if (result.signum() < 0) throw new IllegalArgumentException("Insufficient amount");
        return new Money(result, currency);
    }
    public boolean isGreaterThan(Money other) { checkCurrency(other); return amount.compareTo(other.amount) > 0; }
    public boolean isZero() { return amount.signum() == 0; }
    private void checkCurrency(Money other) {
        if (!currency.equals(other.currency)) throw new IllegalArgumentException("Currency mismatch");
    }
    @Override public String toString() { return currency.getCurrencyCode() + " " + amount; }
}
