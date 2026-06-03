package com.interview.practice.statergy;

import com.interview.practice.model.Elevator;
import com.interview.practice.model.ExternalRequest;
import com.interview.practice.model.InternalRequest;
import com.interview.practice.model.Request;

import java.util.List;

public interface DispatcherStatergy {

    Elevator selectElevator(
        List<Elevator> elevators,
        Request request);

   // Elevator selectElevator(List<Elevator> elevators, ExternalRequest request);
   // Elevator selectElevator(List<Elevator> elevators, InternalRequest request);
}