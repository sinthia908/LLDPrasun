package com.interview.practice.service;
import com.interview.practice.model.Transaction;

import java.util.*;

public class TransactionHistory {

        private final Deque<Transaction> history = new ArrayDeque<>();

        void add(Transaction tx) {
            history.addFirst(tx);
        }

       /* List<Transaction> getLatest(int n) {
            return history.stream().limit(n).toList();
        }*/
    }

