package com.interview.practice.model;

public class TransactionFactory {

    static Transaction createAddMoneyTx(String txId,Wallet wallet,double amount,PaymentStatergy paymentStatergy){
          return new AddMoneyTransaction(txId,wallet,amount,paymentStatergy);
    }
    static Transaction createSendMoneyTx(String txid,User sendFrom,User sendTo,long amount){
        return new SendMoneyTransaction(txid,sendFrom,sendTo,amount);
    }

}
