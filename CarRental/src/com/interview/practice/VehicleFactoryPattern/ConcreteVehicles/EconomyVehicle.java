package com.interview.practice.VehicleFactoryPattern.ConcreteVehicles;

import com.interview.practice.CommonEnums.VehicleEnums.VehicleType;
import com.interview.practice.VehicleFactoryPattern.Vehicle;

public class EconomyVehicle extends Vehicle {

    private static final double RATE_MULTIPLIER = 1.0;
    public EconomyVehicle(String registrationNumber, String model, VehicleType type, double baseRentalPrice) {
        super(registrationNumber, model, type, baseRentalPrice);
    }

    @Override
    public double calculateRentalFee(int days) {
        return getBaseRentalPrice() * days * RATE_MULTIPLIER;
    }
}
