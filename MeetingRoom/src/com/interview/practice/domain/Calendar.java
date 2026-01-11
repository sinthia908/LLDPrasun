package com.interview.practice.domain;

import com.interview.practice.lock.ILockRoomProvider;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private  List<Meeting> meetingList = new ArrayList<>();

    public boolean isTimeSlotAvailable(TimeSlot timeSlot) {
            for (Meeting existing : meetingList) {
                if (existing.getTimeSlot().overlaps(timeSlot))
                    return false;
            }
        return true;
    }

    void addMeeting(Meeting meeting){
           meetingList.add(meeting);
    }
}
