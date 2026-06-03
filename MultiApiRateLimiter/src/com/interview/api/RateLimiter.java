package com.interview.api.RateLimi

import com.example.ratelimiter.exception.RateLimitExceededException;
import com.example.ratelimiter.model.RequestContext;
import com.example.ratelimiter.model.RateLimitRule;
import com.example.ratelimiter.resolver.RuleResolver;
import com.example.ratelimiter.store.CounterStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RateLimiter {

    private static final Logger logger =
            LoggerFactory.getLogger(RateLimiter.class);

    private final RuleResolver resolver;
    private final CounterStore store;

    public RateLimiter(RuleResolver resolver, CounterStore store) {
        this.resolver = resolver;
        this.store = store;
    }

    public boolean allow(RequestContext request) {
        List<RateLimitRule> rules = resolver.resolve(request);

        for (RateLimitRule rule : rules) {
            boolean allowed = rule.getStrategy().allow(request, rule, store);

            if (!allowed) {
                logger.warn("Rate limit exceeded for rule={}, user={}",
                        rule.getRuleId(), request.getUserId());

                throw new RateLimitExceededException(
                        "Rate limit exceeded for " + rule.getRuleId()
                );
            }
        }

        return true;
    }
}