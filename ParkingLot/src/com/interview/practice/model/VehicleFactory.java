package com.interview.practice.model;

public class VehicleFactory {

    public static Vehicle createVehicle(String vehicleType, String license, ParkingFeeStratergy parkingFeeStratergy) {
        if (vehicleType.equalsIgnoreCase("Car")) {
            return new CarVehicle(license, vehicleType, parkingFeeStratergy);
        } else if (vehicleType.equalsIgnoreCase("Car")) {
            return new BikeVehicle(license, vehicleType, parkingFeeStratergy);
        }
        return new OtherVehicle(license,vehicleType,parkingFeeStratergy);
    }
}
