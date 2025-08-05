package com.interview.practice.model;

public interface ISubscriber {

    String getId();
    void onMessage(Message message) throws InterruptedException;

}
