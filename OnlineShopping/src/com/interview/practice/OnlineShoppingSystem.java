package com.interview.practice;

import com.interview.practice.models.Customer;
import com.interview.practice.models.Order;
import com.interview.practice.models.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineShoppingSystem {

    // Data Stores
    private static OnlineShoppingSystem instance;
    private final Map<String, Product> products;
    private final Map<String, Customer> customers;
    private final Map<String, Order> orders;

    // Services




    private OnlineShoppingSystem(){
            products = new ConcurrentHashMap<>();
            customers = new ConcurrentHashMap<>();
            orders = new ConcurrentHashMap<>();
    }


    public static OnlineShoppingSystem getInstance() {
        if (instance == null)
            synchronized (OnlineShoppingSystem.class) {
                if (instance == null) {
                    instance = new OnlineShoppingSystem();
                    return instance;
                }
            }
        return instance;
    }

}
