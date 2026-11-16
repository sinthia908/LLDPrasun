package com.interview.practice.VehicleFactoryPattern;

import com.interview.practice.CommonEnums.VehicleEnums.VehicleType;
import com.interview.practice.VehicleFactoryPattern.ConcreteVehicles.EconomyVehicle;
import com.interview.practice.VehicleFactoryPattern.ConcreteVehicles.LuxuryVehicle;
import com.interview.practice.VehicleFactoryPattern.ConcreteVehicles.SUVVehicle;

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleType vehicleType, String registrationNumber, String model, double baseRentalPrice) {
        switch (vehicleType) {
            case ECONOMY:
                return new EconomyVehicle(registrationNumber, model, vehicleType,  baseRentalPrice);
            case LUXURY:
                return new LuxuryVehicle(registrationNumber, model, vehicleType, baseRentalPrice);
            case SUV:
                return new SUVVehicle(registrationNumber, model,vehicleType,  baseRentalPrice);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type: " + vehicleType);
        }
    }
}
