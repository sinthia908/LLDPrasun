package com.interview.practice.model;

import java.util.List;

public class ParkingLotService {
    private List<ParkingSpot> parkingSpots;

    public ParkingLotService(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    // Method to find an available spot based on vehicle type

    public ParkingSpot findAvailableSpot(String vehicleType) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied() && spot.getSpotType().equals(vehicleType))
                return spot;
        }
        return null;
    }

    // Method to park a vehicle

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getVehicleType());
        if (spot != null) {
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully in spot:" + spot.getSpotNumber());
        }
        return spot;
        System.out.println(
                 "No parking spots available for " + vehicle.getVehicleType() + "!");
        return null;
    }

    // Method to vacate a parking spot

     public void vacateSpot(ParkingSpot spot,Vehicle vehicle){

         if (spot != null && spot.isOccupied()
                 && spot.getVehicle().equals(vehicle)) {
             spot.vacate(); // Free the spot
             System.out.println(vehicle.getVehicleType()
                     + " vacated the spot: " + spot.getSpotNumber());
         } else {
             System.out.println("Invalid operation! Either the spot is already vacant "
                     + "or the vehicle does not match.");
         }
     }
     // Method to find a spot by its number

      public ParkingSpot getSpotNumber(int spotNumber) {
          for (ParkingSpot parkingSpot : parkingSpots) {
              if (parkingSpot.getSpotNumber() == spotNumber)
                  return parkingSpot;
          }
          return null; // Spot Not Found
        }

      // Getter for parking spots

       public List<ParkingSpot> getParkingSpots(){
              return parkingSpots;
         }

     }

