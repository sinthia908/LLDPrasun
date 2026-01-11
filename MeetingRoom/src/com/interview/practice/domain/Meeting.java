package com.interview.practice.domain;

import com.interview.practice.lock.ILockRoomProvider;

import java.util.List;

public class Meeting {

    private final String meetingId;
    private final MeetingRoom meetingRoom;
    private final TimeSlot timeSlot;
    private final User host;
    private final List<User> participants;

    public Meeting(String meetingId, MeetingRoom meetingRoom, TimeSlot timeSlot, User host, List<User> participants){
           this.meetingId = meetingId;
           this.meetingRoom = meetingRoom;
           this.timeSlot = timeSlot;
           this.host = host;
           this.participants = participants;
    }


    public String getMeetingId() {
        return meetingId;
    }


    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public User getHost() {
        return host;
    }

    public List<User> getParticipants() {
        return participants;
    }
}
