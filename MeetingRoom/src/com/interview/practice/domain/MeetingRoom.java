package com.interview.practice.domain;

public class MeetingRoom {

    private final String meetingRoomid;
    private final String roomName;
    private final int capacity;
    private final Calendar calendar;

    private  MeetingStatus meetingStatus;

    public MeetingRoom(String meetingRoomid, String roomName, int capacity) {
        this.meetingRoomid = meetingRoomid;
        this.roomName = roomName;
        this.capacity = capacity;
        this.calendar = new Calendar();

    }

    public boolean isAvailable(TimeSlot timeSlot) {
        return calendar.isTimeSlotAvailable(timeSlot);
    }

    public MeetingStatus getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(MeetingStatus meetingStatus) {
               this.meetingStatus = meetingStatus;
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

    public Calendar getCalendar() {
        return calendar;
    }
}







