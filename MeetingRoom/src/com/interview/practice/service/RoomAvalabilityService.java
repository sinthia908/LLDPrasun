package com.interview.practice.service;

import com.interview.practice.domain.MeetingRoom;
import com.interview.practice.domain.TimeSlot;

public class RoomAvalabilityService {



    // Default Constructor
    public RoomAvalabilityService() {

    }


    boolean isRoomAvailable(MeetingRoom room, TimeSlot slot) {
            return room.isAvailable(slot);
    }


}
