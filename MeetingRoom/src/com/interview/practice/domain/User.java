package com.interview.practice.domain;

public class User {

    private final String userId;
    private final String name;
    private final String emailId;
    private final long phoneNumber;


    public User(String userId,String name,String emailId,long phoneNumber){
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;

    }



}
