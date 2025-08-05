package com.interview.practice.model;

public interface IPublisher {

    String getId();

    void publish(String topicId,String message) throws IllegalArgumentException;
}
