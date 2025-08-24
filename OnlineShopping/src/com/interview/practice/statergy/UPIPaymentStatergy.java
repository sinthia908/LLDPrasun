package com.interview.practice.statergy;

public class UPIPaymentStatergy implements PaymentStatergy{

    private final String upiId;

    UPIPaymentStatergy(String upiId){
    this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing UPI payment of $");
        return false;
    }
}
