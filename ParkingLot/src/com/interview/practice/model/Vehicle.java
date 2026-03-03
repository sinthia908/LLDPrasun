package com.interview.practice.model;

public abstract class Vehicle {
    private String licenseNumber; // Store the vehicle's license plate number.
    private String vehicleType; // Stores the type of Vehicle
    private ParkingFeeStratergy parkingFeeStratergy; // Strategy for calculating parking fees
    // Constructor to initialize a vehicle with its license plate, type, and fee strategy

    public Vehicle(String licenseNumber,String vehicleType,ParkingFeeStratergy parkingFeeStratergy){
           this.licenseNumber = licenseNumber;
           this.vehicleType = vehicleType;
           this.parkingFeeStratergy = parkingFeeStratergy;
    }

    protected Vehicle() {
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    // Method to calculate parking fee based on duration and duration type
    public double calculateFee(int duration, DurationType durationType) {
        return parkingFeeStratergy.calculateFee(vehicleType, duration, durationType);
    }


}
