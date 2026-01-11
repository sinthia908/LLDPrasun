package com.interview.practice.lock;

import com.interview.practice.domain.Calendar;
import com.interview.practice.domain.MeetingRoom;
import com.interview.practice.domain.TimeSlot;
import com.interview.practice.domain.User;

import java.util.Date;
import java.util.List;

public interface ILockRoomProvider {

    void LockRooms(TimeSlot slot, List<MeetingRoom> meetingRooms, User user);

    void LockRooms(TimeSlot slot, MeetingRoom meetingRoom, User user);

    void unlockRoom(TimeSlot slot, List<MeetingRoom> meetingRooms, User user);

    void unlockRoom(TimeSlot slot, MeetingRoom meetingRooms, User user);

    boolean validateLock(TimeSlot slot,MeetingRoom meetingRoom,User user);

    List<MeetingRoom> getLockedRooms(TimeSlot slot);

    }

