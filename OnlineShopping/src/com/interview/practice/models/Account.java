package com.interview.practice.models;

import jdk.tools.jlink.internal.plugins.StripNativeCommandsPlugin;

public class Account {

    private String userName;
    private String password; // hashed password
    private ShoppingCart cart;


    public Account(String userName,String password){
         this.userName = userName;
         this.password = password;
    }
}



