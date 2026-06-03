package com.interview;

public class RateLimitRule {

    private final String ruleId;
    private final LimitType limitType;

    private final String api;
    private final String groupId;

    private final int maxRequests;
    private final long windowSizeMs;

    private final String strategy;

    public RateLimitRule(String ruleId, LimitType limitType, String api,
                         String groupId, int maxRequests,
                         long windowSizeMs, String strategy) {
        this.ruleId = ruleId;
        this.limitType = limitType;
        this.api = api;
        this.groupId = groupId;
        this.maxRequests = maxRequests;
        this.windowSizeMs = windowSizeMs;
        this.strategy = strategy;
    }

    public String getRuleId() { return ruleId; }
    public LimitType getLimitType() { return limitType; }
    public String getApi() { return api; }
    public String getGroupId() { return groupId; }
    public int getMaxRequests() { return maxRequests; }
    public long getWindowSizeMs() { return windowSizeMs; }
    public String getStrategy() { return strategy; }
}