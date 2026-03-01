package com.interview.practice.model;

public class CreditCardPaymentStatergy extends PaymentStatergy{

    public CreditCardPaymentStatergy(double fee){

    }


    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment ");
    }
}
