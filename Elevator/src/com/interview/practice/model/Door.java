package com.interview.practice.model;

public class Door {

    private boolean open;

    public void open() {
        open = true;
        System.out.println("Door opened");
    }

    public void close() {
        open = false;
        System.out.println("Door closed");
    }

    public boolean isOpen() {
        return open;
    }
}