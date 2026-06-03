package com.interview.practice.model;

public class InternalRequest extends Request {

    private final int destinationFloor;

    public InternalRequest(int destinationFloor) {
        super();
        this.destinationFloor = destinationFloor;
    }

    @Override

    public int getFloor(){
        return destinationFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}