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
    private OrderState currentState;

    public Order(Customer customer, List<OrderLineItem> lineItemList,
                 Address shippingAddress, double totalAmount){
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.lineItemList = lineItemList;
        this.shippingAddress = shippingAddress;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
        this.currentState = null;
       // addObserver(customer);

    }

    // State Pattern Methods

    //public void shipOrder();
    //public void deliverOrder();
    // public void cancelOrder();

    public List<OrderLineItem> getLineItemList() {
        return lineItemList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getId() {
        return id;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public OrderState getCurrentState() {
        return currentState;
    }



}


