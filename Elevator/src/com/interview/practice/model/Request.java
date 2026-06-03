package com.interview.practice.model;

public abstract class Request {

    protected final long timestamp;

    public Request() {

        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public abstract int getFloor();
}