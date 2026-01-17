package com.interview.practice.service;

import com.interview.practice.domain.Meeting;
import com.interview.practice.domain.MeetingRoom;
import com.interview.practice.domain.TimeSlot;
import com.interview.practice.repository.MeetingRepository;

import java.util.*;

public class RoomAvalabilityService {
    private final MeetingRepository meetingRepository;

    // Default Constructor
    public RoomAvalabilityService(MeetingRepository meetingRepository){
          this.meetingRepository = meetingRepository;

    }

    boolean isRoomAvailable(String roomid,TimeSlot timeSlot) {

        List<Meeting> meetings = meetingRepository.findByRoom(roomid);

        for (Meeting meeting : meetings) {
            if (meeting.getTimeSlot().overlaps(timeSlot)) {
                return false;
            }
        }
        return true;
    }

    // Get all the available rooms based on the timeslot


/*    List<MeetingRoom> getAvailableRooms(TimeSlot slot) {
        List<MeetingRoom> available = new ArrayList<>();

        for (MeetingRoom room : allRooms) {
            boolean isBooked = false;
            for (Meeting meeting : meetingRepository.findByRoom(room.getId())) {
                if (meeting.getTimeSlot().overlaps(slot)) {
                    isBooked = true;
                    break;
                }
            }
            if (!isBooked) {
                available.add(room);
            }
        }
        return available;
    }*/



}
