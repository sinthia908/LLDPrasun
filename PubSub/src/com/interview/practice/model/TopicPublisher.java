package com.interview.practice.model;

public class TopicPublisher {

    private final Topic topic;

    private final IPublisher publisher;

    public TopicPublisher(Topic topic,IPublisher publisher){

    this.topic = topic;
    this.publisher = publisher;

    }

    // Getter for the class

    public Topic getTopic() {
        return topic;
    }

    public IPublisher getPublisher() {
        return publisher;
    }



}

