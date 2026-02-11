package com.interview.practice.model;

public interface TransactionObserver {
       void notify(String txId,TransactionStatus transactionStatus);

}
