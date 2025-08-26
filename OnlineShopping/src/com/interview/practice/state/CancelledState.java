package com.interview.practice.state;

public class CancelledState implements OrderState{
    @Override
    public void shipOrder() {
    System.out.println("Cannot ship a cancel order.");
    }
    @Override
    public void cancelOrder() {
    System.out.println("Order is already cancelled.");
    }

    @Override
    public void deliverOrder() {
    System.out.println("Cannot deliver a cancelled order");
    }
}
