package com.example.ratelimiter.model;

import java.util.Map;

public class RequestContext {
    private final String clientId;
    private final String api;
    private final long timestamp;
    private final Map<String, String> metadata;

    public RequestContext(String clientId, String api, long timestamp, Map<String, String> metadata) {
        this.clientId = clientId;
        this.api = api;
        this.timestamp = timestamp;
        this.metadata = metadata;
    }

    public String getClientId() { return clientId; }
    public String getApi() { return api; }
    public long getTimestamp() { return timestamp; }
    public Map<String, String> getMetadata() { return metadata; }
}