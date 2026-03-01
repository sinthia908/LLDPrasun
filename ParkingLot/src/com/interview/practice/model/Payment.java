package com.interview.practice.model;

public class Payment {

    private double amount;
    private PaymentStatergy paymentStatergy; // Payment strategy interface

    // Constructor to initialize the payment amount and payment strategy

    public Payment(double amount,PaymentStatergy paymentStatergy){
           this.amount = amount;
           this.paymentStatergy = paymentStatergy;
    }

    // Process the payment using Statergy Pattern

    public void processPayment(){
        if ( amount > 0 ){
            paymentStatergy.processPayment(amount); // Delegating to strategy
        } else {
            System.out.print("Invalid payment ");
        }
    }
}
