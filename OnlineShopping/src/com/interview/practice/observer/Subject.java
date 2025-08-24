package com.interview.practice.observer;

import com.interview.practice.models.Order;

public interface Subject {

    public void addObserver(OrderObserver orderObserver);
    public void removeObserver(OrderObserver orderObserver);
    public void notifyObservers(Order order);
}
