package com.interview.practice.model;

import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {

    private final int id;

    private int currentFloor;

    private Direction direction;

    private ElevatorState state;

    private final Door door;

    private final Queue<Integer> upStops;

    private final Queue<Integer> downStops;

    public Elevator(int id) {

        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;

        this.door = new Door();

        this.upStops = new PriorityQueue<>();

        this.downStops =
                new PriorityQueue<>((a, b) -> b - a);
    }

    public synchronized void submitRequest(int floor) {

        if (floor > currentFloor) {
            upStops.offer(floor);
        } else if (floor < currentFloor) {
            downStops.offer(floor);
        } else {
            openDoor();
        }
    }

    public void move() {

        if (!upStops.isEmpty()) {
            moveUp();
        } else if (!downStops.isEmpty()) {
            moveDown();
        } else {
            state = ElevatorState.IDLE;
            direction = Direction.IDLE;
        }
    }

    private void moveUp() {

        direction = Direction.UP;
        state = ElevatorState.MOVING;

        Integer nextFloor = upStops.poll();

        while (currentFloor < nextFloor) {
            currentFloor++;
            System.out.println(
                    "Elevator " + id +
                            " moving up to " + currentFloor
            );
        }

        stopAtFloor();
    }

    private void moveDown() {

        direction = Direction.DOWN;
        state = ElevatorState.MOVING;

        Integer nextFloor = downStops.poll();

        while (currentFloor > nextFloor) {
            currentFloor--;
            System.out.println(
                    "Elevator " + id +
                            " moving down to " + currentFloor
            );
        }

        stopAtFloor();
    }

    private void stopAtFloor() {

        state = ElevatorState.STOPPED;

        openDoor();

        closeDoor();
    }

    private void openDoor() {
        door.open();
    }

    private void closeDoor() {
        door.close();
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getState() {
        return state;
    }
}