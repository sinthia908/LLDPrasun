package com.interview.practice.Domain;


import com.interview.practice.CommonEnum.RoomType;

public class Room {

    private final String roomId;

    private final String hotelId;

    private final RoomType roomType;

    private final int capacity;

    public Room(
            String roomId,
            String hotelId,
            RoomType roomType,
            int capacity
    ) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.capacity = capacity;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getCapacity() {
        return capacity;
    }
}