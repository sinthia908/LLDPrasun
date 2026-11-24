package com.interview.practice;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class InMemoryTTLCache<K, V> implements AutoCloseable {

    // ---------------- CACHE ENTRY ----------------
    private static final class CacheEntry<V> {
        private final V value;
        private final long expiryTimeNanos;

        CacheEntry(V value, long expiryTimeNanos) {
            this.value = value;
            this.expiryTimeNanos = expiryTimeNanos;
        }

        boolean isExpired() {
            return System.nanoTime() >= expiryTimeNanos;
        }
    }

    // ---------------- EXPIRY TASK ----------------
    private static final class ExpiryTask<K, V> implements Delayed {

        private final K key;
        private final CacheEntry<V> entry;

        ExpiryTask(K key, CacheEntry<V> entry) {
            this.key = key;
            this.entry = entry;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long remaining = entry.expiryTimeNanos - System.nanoTime();

            return unit.convert(remaining, TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            ExpiryTask<?, ?> task = (ExpiryTask<?, ?>) other;

            return Long.compare(
                    this.entry.expiryTimeNanos,
                    task.entry.expiryTimeNanos
            );
        }
    }

    // ---------------- CACHE STORAGE ----------------
    private final ConcurrentHashMap<K, CacheEntry<V>> cache =
            new ConcurrentHashMap<>();

    // Keeps expiry events ordered by expiry time
    private final DelayQueue<ExpiryTask<K, V>> expiryQueue =
            new DelayQueue<>();

    private final AtomicBoolean running = new AtomicBoolean(true);

    private final Thread expiryWorker;

    // ---------------- CONSTRUCTOR ----------------
    public InMemoryTTLCache() {

        expiryWorker = new Thread(
                this::cleanupExpiredEntries,
                "cache-expiry-worker"
        );

        expiryWorker.setDaemon(true);
        expiryWorker.start();
    }

    // ---------------- SET / PUT ----------------
    public void put(K key, V value, long ttl, TimeUnit unit) {

        if (key == null || value == null) {
            throw new IllegalArgumentException(
                    "Key and value cannot be null"
            );
        }

        if (ttl <= 0) {
            remove(key);
            return;
        }

        long ttlNanos = unit.toNanos(ttl);
        long expiryTime = System.nanoTime() + ttlNanos;

        CacheEntry<V> newEntry =
                new CacheEntry<>(value, expiryTime);

        // Replace existing entry
        cache.put(key, newEntry);

        // Add expiry event
        expiryQueue.offer(new ExpiryTask<>(key, newEntry));
    }

    // ---------------- GET ----------------
    public V get(K key) {

        CacheEntry<V> entry = cache.get(key);

        if (entry == null) {
            return null;
        }

        // Lazy expiration check
        if (entry.isExpired()) {

            // Remove only if this is still the same entry
            cache.remove(key, entry);

            return null;
        }

        return entry.value;
    }

    // ---------------- REMOVE ----------------
    public void remove(K key) {
        cache.remove(key);
    }

    // ---------------- SIZE ----------------
    public int size() {
        return cache.size();
    }

    // ---------------- CLEANUP WORKER ----------------
    private void cleanupExpiredEntries() {

        while (running.get()) {

            try {
                // Blocks until an expiry task becomes eligible
                ExpiryTask<K, V> task = expiryQueue.take();

                // Remove only if the map still contains this version
                cache.remove(task.key, task.entry);

            } catch (InterruptedException e) {

                if (!running.get()) {
                    break;
                }
            }
        }
    }

    // ---------------- SHUTDOWN ----------------
    @Override
    public void close() {

        running.set(false);
        expiryWorker.interrupt();
    }
}


