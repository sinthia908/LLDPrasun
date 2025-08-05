package com.interview.practice.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private String topicName; // Name of the topic, used for identification/display purposes.
    private String topicId; // Unique Identifier for the topic
    private List<Message> messageList;

    // List to store all messages published to this topic.
    // This list is exposed to the outside using an immutable getter.
    public Topic(String topicId,String topicName){
           this.topicId = topicId;
           this.topicName = topicName;
           this.messageList = new ArrayList<>();

    }

    public void addMessage(Message message){
          messageList.add(message);
    }




}
