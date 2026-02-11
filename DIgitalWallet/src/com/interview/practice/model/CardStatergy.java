package com.interview.practice.model;

public class CardStatergy implements PaymentStatergy{
    @Override
    public boolean pay(double amount) {
        return false;
    }
}
