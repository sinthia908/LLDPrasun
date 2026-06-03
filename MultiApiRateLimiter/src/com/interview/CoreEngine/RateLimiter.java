package com.interview.CoreEngine;


import com.interview.Exception.RateLimitExceededException;
import com.interview.KeyBuilder.KeyBuilder;
import com.interview.RateLimitRule;
import com.interview.resolver.RuleResolver;

import java.util.List;
import java.util.Map;

public class RateLimiter {

    private final RuleResolver resolver;
    private final Map<String, com.interview.strategy.CounterStrategy> strategies;

    public RateLimiter(RuleResolver resolver,
                       Map<String, com.interview.strategy.CounterStrategy> strategies) {
        this.resolver = resolver;
        this.strategies = strategies;
    }

    public void allow(com.example.ratelimiter.model.RequestContext ctx) {

        List<RateLimitRule> rules = resolver.resolve(ctx);

        for (RateLimitRule rule : rules) {

            String key = KeyBuilder.build(ctx, rule);

            com.interview.strategy.CounterStrategy strategy = strategies.get(rule.getStrategy());

            if (strategy == null) {
                throw new RuntimeException("Strategy not found: " + rule.getStrategy());
            }

            boolean allowed = strategy.allow(key, rule, ctx.getTimestamp());

            if (!allowed) {
                throw new RateLimitExceededException(rule);
            }
        }
    }
}