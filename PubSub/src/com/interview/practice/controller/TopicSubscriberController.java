package com.interview.practice.controller;

import com.interview.practice.model.ISubscriber;
import com.interview.practice.model.Topic;

public class TopicSubscriberController {

    private final ISubscriber subscriber;
    private final Topic topic;

    public TopicSubscriberController(ISubscriber subscriber, Topic topic){
           this.subscriber = subscriber;
           this.topic = topic;
    }

    // Getting the setters 
    public Topic getTopic() {
        return topic;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }
}
