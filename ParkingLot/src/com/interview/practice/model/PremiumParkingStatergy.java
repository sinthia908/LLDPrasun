package com.interview.practice.model;


public class PremiumParkingStatergy implements ParkingFeeStratergy {
    @Override
    public double calculateFee(String vehicleType, int duration, DurationType durationType) {
        switch (vehicleType.toLowerCase()) {

            case "car":
                return durationType == DurationType.HOURLY
                        ? duration * 20.0 // $10 for cars
                        : duration * 20.0 * 24;// Daily
            case "bike":
                return durationType == DurationType.HOURLY
                        ? duration * 20.0 // $5 for bike
                        : duration * 20.0 * 24;// Daily

            case "auto":
                return durationType == DurationType.HOURLY
                        ? duration * 20.0 // $8 for bike
                        : duration * 20.0 * 24;// Daily
            default:
                return durationType == DurationType.HOURLY
                        ? duration * 20.0   // $15 per hour for other vehicles
                        : duration * 20.0 * 24;  // Daily rate
        }
    }
}