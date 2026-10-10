package com.interview.practice.ObserverPatternIMP;

import com.interview.practice.CommonEnums.ElevatorState;
import com.interview.practice.UtilityClasses.Elevator;

public interface ElevatorObserver {

    // Called when an elevator's state change

    void onElevatorStateChange(Elevator elevator, ElevatorState state);

    // Called when an elevator changes its current floor
    void onElevatorFloorChange(Elevator elevator, int floor);
}
