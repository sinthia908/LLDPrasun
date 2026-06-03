package com.interview.statergy;


import com.interview.RateLimitRule;
import com.interview.store.CounterStore;

public class FixedWindowStrategy implements com.interview.strategy.CounterStrategy {

    private final CounterStore store;

    public FixedWindowStrategy(CounterStore store) {
        this.store = store;
    }

    @Override
    public boolean allow(String key, RateLimitRule rule, long timestamp) {

        long windowStart = (timestamp / rule.getWindowSizeMs()) * rule.getWindowSizeMs();
        String finalKey = key + ":" + windowStart;

        long count = store.get(finalKey);

        if (count >= rule.getMaxRequests()) {
            return false;
        }

        store.increment(finalKey, rule.getWindowSizeMs());
        return true;
    }
}