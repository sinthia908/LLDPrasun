package com.interview.practice.statergy;

public class CreditCardPaymentStatergy extends PaymentStatergy{

    private final String cardNumber;

    public CreditCardPaymentStatergy(String cardNumber){
          this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        return false;
    }
}
