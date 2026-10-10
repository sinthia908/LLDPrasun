package com.interview.practice.SchedulingAlgoStatergyPattern;

import com.interview.practice.UtilityClasses.Elevator;

public interface SchedulingStatergy {

    // Determines the next stop for the given elevator

    int getNextStop(Elevator elevator);
}
