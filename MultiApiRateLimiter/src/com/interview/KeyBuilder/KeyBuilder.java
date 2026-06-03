package com.interview.KeyBuilder;


import com.interview.LimitType;
import com.interview.RateLimitRule;

public class KeyBuilder {

    public static String build(com.example.ratelimiter.model.RequestContext ctx, RateLimitRule rule) {

        if (rule.getLimitType() == LimitType.API) {
            return ctx.getClientId() + ":API:" + ctx.getApi();
        }

        if (rule.getLimitType() == LimitType.GROUP) {
            return ctx.getClientId() + ":GROUP:" + rule.getGroupId();
        }

        throw new IllegalArgumentException("Invalid rule type");
    }
}