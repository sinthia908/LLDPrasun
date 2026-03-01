package com.interview.practice.model;

public class CashPaymentStatergy implements PaymentStatergy{
    @Override
    public void processPayment(double amount) {
           System.out.print("Processing cash payment of $" + amount);

    }
}
