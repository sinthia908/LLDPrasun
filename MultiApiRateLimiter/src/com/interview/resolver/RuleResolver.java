package com.interview.resolver;

import com.interview.Group;
import com.interview.RateLimitRule;
import com.interview.RequestContext;

import java.util.*;

public class RuleResolver {

    private final Map<String, List<RateLimitRule>> apiRules;
    private final Map<String, Group> groups;
    private final Map<String, List<RateLimitRule>> groupRules;

    public RuleResolver(Map<String, List<RateLimitRule>> apiRules,
                        Map<String, Group> groups,
                        Map<String, List<RateLimitRule>> groupRules) {
        this.apiRules = apiRules;
        this.groups = groups;
        this.groupRules = groupRules;
    }

    public List<RateLimitRule> resolve(RequestContext ctx) {
        List<RateLimitRule> result = new ArrayList<>();

        // API rules
        result.addAll(apiRules.getOrDefault(ctx.getApi(), List.of()));

        // Group rules
        for (Group group : groups.values()) {
            if (group.getApis().contains(ctx.getApi())) {
                result.addAll(groupRules.getOrDefault(group.getGroupId(), List.of()));
            }
        }

        return result;
    }
}