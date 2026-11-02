package com.interview.practice.StatePattern;

import com.interview.practice.StatePattern.ATMContext.ATMMachineContext;

public interface ATMState {

// Get the name of the current state
String getStateName();

// Method to handle state transitions
ATMState next(ATMMachineContext context);

}
