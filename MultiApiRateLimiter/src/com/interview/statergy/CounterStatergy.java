package com.interview.strategy;

import com.interview.RateLimitRule;

public interface CounterStrategy {
    boolean allow(String key, RateLimitRule rule, long timestamp);
}