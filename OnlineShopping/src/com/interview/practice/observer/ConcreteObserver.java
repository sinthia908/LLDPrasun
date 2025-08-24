package com.interview.practice.observer;

import com.interview.practice.models.Order;

import java.util.ArrayList;
import java.util.List;

public abstract class ConcreteObserver implements Subject{

    private final List<OrderObserver> observerList = new ArrayList<>();

    @Override
    public void addObserver(OrderObserver orderObserver) {
        observerList.add(orderObserver);
    }

    @Override
    public void removeObserver(OrderObserver orderObserver) {
        observerList.remove(orderObserver);
    }

    @Override
    public void notifyObservers(Order order) {
        for(OrderObserver observer:observerList){
            observer.update(order);
        }

    }
}
