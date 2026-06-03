package com.interview.practice;

import com.interview.practice.model.Elevator;
import com.interview.practice.model.Request;
import com.interview.practice.statergy.DispatcherStatergy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevators;

    private final DispatcherStatergy dispatchStrategy;

    public ElevatorController(
            int elevatorCount,
            DispatcherStatergy dispatchStrategy) {

        this.dispatchStrategy = dispatchStrategy;

        this.elevators = new ArrayList<>();

        for (int i = 1; i <= elevatorCount; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public void requestElevator(
           Request request) {

        Elevator elevator =
                dispatchStrategy.selectElevator(
                        elevators,
 ]                       request
                );

        if (elevator != null) {

            System.out.println(
                    "Assigning Elevator "
                            + elevator.getId()
                            + " to floor "
                            + request.getFloor()
            );

            elevator.submitRequest(
                    request.getFloor()
            );

            elevator.move();
        }
    }

    public List<Elevator> getElevators() {
        return elevators;
    }
}

