package com.interview.Demo;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        CounterStore store = new InMemoryCounterStore();

        CounterStrategy fixedWindow = new FixedWindowStrategy(store);

        Map<String, CounterStrategy> strategies = Map.of(
                "FIXED_WINDOW", fixedWindow
        );

        // API Rules
        RateLimitRule loginRule = new RateLimitRule(
                "login-5-per-min",
                LimitType.API,
                "/login",
                null,
                5,
                60_000,
                "FIXED_WINDOW"
        );

        // Group
        Group fileGroup = new Group("FILE_OPS",
                List.of("/upload", "/download"));

        RateLimitRule groupRule = new RateLimitRule(
                "file-ops-50-per-hour",
                LimitType.GROUP,
                null,
                "FILE_OPS",
                50,
                3600_000,
                "FIXED_WINDOW"
        );

        Map<String, List<RateLimitRule>> apiRules = Map.of(
                "/login", List.of(loginRule)
        );

        Map<String, Group> groups = Map.of(
                "FILE_OPS", fileGroup
        );

        Map<String, List<RateLimitRule>> groupRules = Map.of(
                "FILE_OPS", List.of(groupRule)
        );

        RuleResolver resolver = new RuleResolver(apiRules, groups, groupRules);

        RateLimiter limiter = new RateLimiter(resolver, strategies);

        String client = "user1";

        for (int i = 1; i <= 10; i++) {
            try {
                RequestContext ctx = new RequestContext(
                        client,
                        "/login",
                        System.currentTimeMillis(),
                        Map.of()
                );

                limiter.allow(ctx);
                System.out.println("Request " + i + " allowed");

            } catch (RateLimitExceededException e) {
                System.out.println("Request " + i + " blocked: " + e.getMessage());
            }
        }
    }
}