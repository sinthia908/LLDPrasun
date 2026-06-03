package com.interview.store;

public interface CounterStore {
    long get(String key);
    void increment(String key, long ttlMs);
}