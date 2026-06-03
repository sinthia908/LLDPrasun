package com.interview.Exception;


import com.interview.RateLimitRule;

public class RateLimitExceededException extends RuntimeException {

    public RateLimitExceededException(RateLimitRule rule) {
        super("Rate limit exceeded for rule: " + rule.getRuleId());
    }
}