package com.interview.practice.model;

public class AddMoneyTransaction extends Transaction{

    private final Wallet wallet;
    private final double amount;
    private final PaymentStatergy statergy;

    public AddMoneyTransaction(String txid,Wallet wallet,double amount,PaymentStatergy statergy){
    super(txid);
    this.wallet = wallet;
    this.amount = amount;
    this.statergy = statergy;
    }


    @Override
    void validate() {

    }

    @Override
    void process() {

    }

    @Override
    void rollback() {

    }
}
