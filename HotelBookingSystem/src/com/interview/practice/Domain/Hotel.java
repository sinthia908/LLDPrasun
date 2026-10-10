package com.interview.practice.Domain;

import java.util.List;

public class Hotel {

    private final String hotelId;

    private final String hotelName;

    private final String city;

    private final List<Room> rooms;

    public Hotel(
            String hotelId,
            String hotelName,
            String city,
            List<Room> rooms
    ) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.city = city;
        this.rooms = rooms;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCity() {
        return city;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
