package com.example.ratelimiter.store;

import com.interview.store.CounterStore;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCounterStore implements CounterStore {

    private static class Counter {
        long count;
        long expiry;
    }

    private final ConcurrentHashMap<String, Counter> map = new ConcurrentHashMap<>();

    @Override
    public long get(String key) {
        Counter c = map.get(key);
        long now = System.currentTimeMillis();

        if (c == null || now > c.expiry) {
            return 0;
        }
        return c.count;
    }

    @Override
    public void increment(String key, long ttlMs) {
        map.compute(key, (k, v) -> {
            long now = System.currentTimeMillis();

            if (v == null || now > v.expiry) {
                Counter c = new Counter();
                c.count = 1;
                c.expiry = now + ttlMs;
                return c;
            }

            v.count++;
            return v;
        });
    }
}