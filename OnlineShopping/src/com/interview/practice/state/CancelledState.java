package com.interview.practice.state;

public class CancelledState implements OrderState{
    @Override
    public void shipOrder() {
    System.out.println("Cannot ship a cancel order");
    }
    @Override
    public void cancelOrder() {
    System.out.println("");
    }

    @Override
    public void deliverOrder() {

    }
}
