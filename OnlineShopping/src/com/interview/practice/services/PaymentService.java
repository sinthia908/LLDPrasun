package com.interview.practice.services;

import com.interview.practice.statergy.PaymentStatergy;

public class PaymentService {

    public boolean processPayment(PaymentStatergy paymentStatergy,double amount){
            return paymentStatergy.pay(amount);
    }
}
