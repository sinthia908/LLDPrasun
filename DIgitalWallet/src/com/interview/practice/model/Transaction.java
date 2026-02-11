package com.interview.practice.model;

import java.time.Instant;

public abstract class Transaction {

    final String txId;
    TransactionStatus status = TransactionStatus.PENDING;
    final Instant timestamp = Instant.now();

    Transaction(String txId){
        this.txId = txId;
    }

    // TEMPLATE METHOD

    final void execute(){
        try{
            validate();
            process();
            status = TransactionStatus.PENDING;
        } catch (Exception e) {
            rollback();
            status = TransactionStatus.FAILED;
        }
    }

    abstract void validate();
    abstract void process();
    abstract void rollback();

}
