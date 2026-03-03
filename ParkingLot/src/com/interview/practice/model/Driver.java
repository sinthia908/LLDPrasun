package com.interview.practice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        // Initialize parking spots
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new CarParkingSpot(1, "Car"));
        parkingSpots.add(new CarParkingSpot(2, "Car"));
        parkingSpots.add(new BikeParkingSpot(3, "Bike"));
        parkingSpots.add(new BikeParkingSpot(4, "Bike"));

        // Initialize Parking Lot

        ParkingLotService parkingLotService = new ParkingLotService(parkingSpots);

        // Create fee statergies

        ParkingFeeStratergy basicHourly = new BasicParkingStatergy();
        ParkingFeeStratergy premiumRateStrategy = new PremiumParkingStatergy();

        // Create Vehicles using Factory Pattern with fee statergies

        Vehicle car1 = VehicleFactory.createVehicle("Car", "CAR123", basicHourly);
        Vehicle car2 = VehicleFactory.createVehicle("Car", "CAR345", basicHourly);

        Vehicle bike1 = VehicleFactory.createVehicle("Bike", "BIKE456", premiumRateStrategy);
        Vehicle bike2 = VehicleFactory.createVehicle("Bike", "BIKE123", premiumRateStrategy);

        // Park vehicles
        ParkingSpot carSpot = parkingLotService.parkVehicle(car1);
        ParkingSpot bikeSpot = parkingLotService.parkVehicle(bike1);

        ParkingSpot carSpot2 = parkingLotService.parkVehicle(car2);
        ParkingSpot bikeSpot2 = parkingLotService.parkVehicle(bike2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method for your vehicle:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");

        int paymentMethod = scanner.nextInt();

        // Process payments using Strategy Patterns

        if (carSpot != null) {
            // Calculate fee using the specific strategy for the vehicle
            double carFee = car1.calculateFee(2, DurationType.HOURLY);
            PaymentStatergy carPaymentStatergy = getPaymentStrategy(paymentMethod, carFee);
            carPaymentStatergy.processPayment(carFee);
            parkingLotService.vacateSpot(carSpot,car1);
        }

        if ( bike1 != null){
            // Calculate fee using the specific strategy for the vehicle
            double bikeFee = bike1.calculateFee(2,DurationType.HOURLY);
            PaymentStatergy bikePaymentStatergy = getPaymentStrategy(paymentMethod,bikeFee);
            bikePaymentStatergy.processPayment(bikeFee);
            parkingLotService.vacateSpot(bikeSpot,bike1);

        }

        scanner.close();
    }

        private static PaymentStatergy  getPaymentStrategy(
        int paymentMethod, double fee) {
            switch (paymentMethod) {
                case 1:
                    return new CreditCardPaymentStatergy(fee);
                case 2:
                    return new CashPaymentStatergy(fee);
                default:
                    System.out.println("Invalid choice! Default to Credit card payment.");
                    return new CreditCardPaymentStatergy(fee);
            }
        }
    }
