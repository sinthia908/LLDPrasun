package com.interview.practice.paymentStrategyPattern.ConcretePaymentStatergies;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
