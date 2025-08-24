package com.interview.practice.models;

import com.interview.practice.enums.OrderStatus;
import com.interview.practice.observer.ConcreteObserver;
import com.interview.practice.observer.OrderObserver;
import com.interview.practice.observer.Subject;
import com.interview.practice.state.OrderState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order extends ConcreteObserver {
    private final String id;
    private final Customer customer;
    private final List<OrderLineItem> lineItemList;
    private final Address shippingAddress;
    private final double totalAmount;
    private final LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private OrderState currentSate;

    private Order(Customer customer,List<OrderLineItem> lineItemList,
                  Address shippingAddress,double totalAmount,
                  LocalDateTime orderDate,OrderStatus orderStatus,
                  OrderState orderState){
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.lineItemList = lineItemList;
        this.shippingAddress = shippingAddress;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
        this.currentSate = null;
       // addObserver(customer);

    }

    // State Pattern Methods

    //public void shipOrder();
    //public void deliverOrder();
    // public void cancelOrder();


}


