package com.interview.practice.observer;

import com.interview.practice.models.Order;

public interface OrderObserver {

    public void update(Order order);
}
