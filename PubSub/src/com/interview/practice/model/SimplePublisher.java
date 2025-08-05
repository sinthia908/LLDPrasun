package com.interview.practice.model;

public class SimplePublisher implements ISubscriber{

    private final String id;

    public SimpleSubscriber(){

    }

    @Override
    public String getId() {
        return "";
    }

    @Override
    public void onMessage(Message message) throws InterruptedException {

    }
}
