package com.interview.practice.models;

import java.util.UUID;

public class Customer {
    private final String id;
    private final String name;
    private final String email;
    private final String password;

    public Account getAccount() {
        return account;
    }

    private final Account account;
    private final Address shippingAddress;


    public Customer(String name,String email,String password,Address shippingAddress){
           this.id = UUID.randomUUID().toString();
           this.name = name;
           this.email = email;
           this.password = password;
           this.account = new Account(name,email);
           this.shippingAddress = shippingAddress;
    }


    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Address getShippingAddress() {
        return shippingAddress;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword(){
        return password;
    }
}