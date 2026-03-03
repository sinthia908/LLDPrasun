package com.interview.practice.model;

public class CreditCardPaymentStatergy implements PaymentStatergy{

    public CreditCardPaymentStatergy(double fee){
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of Amount of :" + amount );
    }
}
