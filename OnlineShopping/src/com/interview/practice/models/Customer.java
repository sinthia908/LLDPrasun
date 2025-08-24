package com.interview.practice.models;

import java.util.UUID;

public class Customer {
    private final String id;
    private final String name;
    private final String email;
    private final Account account;
    private final Address shippingAddress;


    public Customer(String id,String name,String email,Account account,Address shippingAddress){
           this.id = UUID.randomUUID().toString();
           this.name = name;
           this.email = email;
           this.account = account;
           this.shippingAddress = shippingAddress;
    }



}
