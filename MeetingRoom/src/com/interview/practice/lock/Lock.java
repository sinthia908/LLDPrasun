package com.interview.practice.lock;

import com.interview.practice.domain.MeetingRoom;
import com.interview.practice.domain.TimeSlot;
import com.interview.practice.domain.User;

import java.time.Instant;
import java.util.Date;

public class Lock {
    private final MeetingRoom meetingRoom;
    private final TimeSlot timeSlot;
    private final Integer timeOutInSeconds;
    private final Date locktime;
    private final User lockedBy;

    public Lock(MeetingRoom meetingRoom, TimeSlot timeSlot, Integer timeOutInSeconds,
                Date locktime, User lockedBy) {
        this.meetingRoom = meetingRoom;
        this.timeSlot = timeSlot;
        this.timeOutInSeconds = timeOutInSeconds;
        this.locktime = locktime;
        this.lockedBy = lockedBy;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Integer getTimeOutInSeconds() {
        return timeOutInSeconds;
    }

    public Date getLocktime() {
        return locktime;
    }

    public User getLockedBy() {
        return lockedBy;
    }

    public boolean isLockExpired(){
        final Instant lockInstant = locktime.toInstant().plusSeconds(timeOutInSeconds);
        final Instant currentTime = new Date().toInstant();
        return lockInstant.isBefore(currentTime);
    }
}