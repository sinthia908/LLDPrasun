package com.interview.practice.driver;

import com.interview.practice.ElevatorController;
import com.interview.practice.model.Direction;
import com.interview.practice.model.ExternalRequest;
import com.interview.practice.model.InternalRequest;
import com.interview.practice.statergy.NearestElevatorStatergy;

public class Main {

    public static void main(String[] args) {

        ElevatorController controller =
                new ElevatorController(
                        3,
                        new NearestElevatorStatergy()
                );

        controller.requestElevator(
                new ExternalRequest(
                        5,
                        Direction.UP
                )
        );

        controller.requestElevator(
                new InternalRequest(
                        2
                )
        );

        controller.requestElevator(
                new ExternalRequest(
                        8,
                        Direction.UP
                )
        );
    }
}