package com.interview.practice.domain;

public class MeetingRoom {

    private final String meetingRoomid;
    private final String roomName;
    private final int capacity;

    public MeetingRoom(String meetingRoomid, String roomName, int capacity) {
        this.meetingRoomid = meetingRoomid;
        this.roomName = roomName;
        this.capacity = capacity;

    }

    public String getMeetingRoomid() {
        return meetingRoomid;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getCapacity() {
        return capacity;
    }

}







