package com.interview.practice.statergy;

import com.interview.practice.model.Elevator;
import com.interview.practice.model.ExternalRequest;
import com.interview.practice.model.InternalRequest;
import com.interview.practice.model.Request;

import java.util.List;

public class NearestElevatorStatergy implements DispatcherStatergy{
    @Override

    public Elevator selectElevator(
                List<Elevator> elevators,
                Request request) {

            Elevator bestElevator = null;

            int minDistance = Integer.MAX_VALUE;

            for (Elevator elevator : elevators) {

                int distance =
                        Math.abs(
                                elevator.getCurrentFloor()
                                        - request.getFloor()
                        );

                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }

            return bestElevator;
        }
    }
