package com.interview.practice.model;

public class SendMoneyTransaction extends Transaction{
    private final User sendFrom;
    private final User sendTo;
    private final double amount;

    SendMoneyTransaction(String txid,User sendFrom,User sendTo,double amount){
        super(txid);
        this.sendFrom = sendFrom;
        this.sendTo = sendTo;
        this.amount = amount;
    }

}
