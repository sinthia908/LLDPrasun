package com.interview.practice;

import com.interview.practice.model.Transaction;
import com.interview.practice.model.TransactionObserver;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class TransactionManager {

    private static final TransactionManager INSTANCE = new TransactionManager();

    private final Map<String, Transaction> txStore = new ConcurrentHashMap<>();
    private final List<TransactionObserver> observers = new ArrayList<>();

    private TransactionManager() {}

    static TransactionManager getInstance() {
        return INSTANCE;
    }

    void registerObserver(TransactionObserver obs) {
        observers.add(obs);
    }

  /*  Transaction process(Transaction tx) {
        if (txStore.containsKey(tx.txId)) {
            return txStore.get(tx.txId); // idempotency
        }

        tx.execute();
        txStore.put(tx.txId, tx);

        for (TransactionObserver obs : observers) {
            obs.notify(tx.txId, tx.status);
        }

        return tx;
    }*/
}
