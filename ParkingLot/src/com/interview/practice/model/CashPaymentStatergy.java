package com.interview.practice.model;

public class CashPaymentStatergy implements PaymentStatergy{

    public CashPaymentStatergy(double fee){

    }

    @Override
    public void processPayment(double amount) {
           System.out.print("Processing cash payment of $" + amount);

    }
}
