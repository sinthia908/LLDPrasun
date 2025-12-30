package com.interview.practice.models;


public class Account {

    private String userName;
    private String password; // hashed password
    private ShoppingCart cart;


    public Account(String userName,String password){
         this.userName = userName;
         this.password = password;
         this.cart = new ShoppingCart();

    }

    public ShoppingCart getCart() {
        return cart;
    }
}



