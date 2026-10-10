package com.interview.practice.ConcreteLockProviders;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InMemoryLockProvider
        implements LockProvider {

    private final ConcurrentHashMap<String, Lock>
            lockMap = new ConcurrentHashMap<>();

    @Override
    public Lock getLock(String resourceId) {

        return lockMap.computeIfAbsent(
                resourceId,
                key -> new ReentrantLock()
        );
    }
}