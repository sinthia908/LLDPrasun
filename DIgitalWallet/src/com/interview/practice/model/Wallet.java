package com.interview.practice.model;

import java.util.concurrent.locks.ReentrantLock;

public class Wallet {

    private final ReentrantLock lock = new ReentrantLock();
    private double balance;


    void lock(){
        lock.lock();
    }

    void unlock(){
        lock.unlock();
    }

    double getBalance(){
        return balance;
    }

    void credit(double amount){
         balance += amount;
    }

    void debit(double amount){
        if (balance < amount){
            throw new RuntimeException("Insufficient balance");
        }
        balance -= amount;
    }




}
