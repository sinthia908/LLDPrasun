package com.interview.practice.model;

public class ExternalRequest extends Request {

    private final int floor;

    private final Direction direction;

    public ExternalRequest(
            int floor,
            Direction direction) {
        super();
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }


}