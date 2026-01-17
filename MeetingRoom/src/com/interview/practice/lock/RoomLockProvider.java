package com.interview.practice.lock;

import com.interview.practice.domain.MeetingRoom;
import com.interview.practice.domain.TimeSlot;
import com.interview.practice.domain.User;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RoomLockProvider implements ILockRoomProvider{

    private final Integer timeOutInSeconds;

    private final Map<TimeSlot, Map<MeetingRoom,Lock>> locks;

    public RoomLockProvider(Integer timeOutInSeconds){
        this.timeOutInSeconds = timeOutInSeconds;
        this.locks = new ConcurrentHashMap<>();
    }

    @Override
    public void LockRooms(TimeSlot slot, List<MeetingRoom> meetingRooms, User user) {
    Map<MeetingRoom,Lock> roomLocks = locks.computeIfAbsent(slot,s-> new ConcurrentHashMap<>());
    synchronized (roomLocks){
        for(MeetingRoom meetingRoom:meetingRooms){
           if (roomLocks.containsKey(meetingRoom)){
               Lock exitinglock= roomLocks.get(meetingRoom);
               if (!exitinglock.isLockExpired()){
                   System.out.print("");
               }
           }
        }

        // All Seats Available lock them together

        Date date = new Date();
        for(MeetingRoom meetingRoom:meetingRooms){
            Lock lock = new Lock(meetingRoom,slot,timeOutInSeconds,date,user);
            roomLocks.put(meetingRoom,lock);
          }
       }
    }

    @Override
    public void LockRooms(TimeSlot slot, MeetingRoom meetingRoom, User user) {
        Map<MeetingRoom,Lock> roomLocks = locks.computeIfAbsent(slot,s-> new ConcurrentHashMap<>());
        synchronized (roomLocks){
               Lock exitinglock  = roomLocks.get(meetingRoom);
                    if (exitinglock != null && !exitinglock.isLockExpired()){
                        System.out.print("");
                    }
                }
            // All Seats Available lock them together

                Date date = new Date();

                Lock lock = new Lock(meetingRoom,slot,timeOutInSeconds,date,user);
                roomLocks.put(meetingRoom,lock);
            }


    @Override
    public void unlockRoom(TimeSlot slot, List<MeetingRoom> meetingRooms, User user) {

   Map<MeetingRoom,Lock> roomLocks =  locks.get(slot);

   if (roomLocks == null) return;

   synchronized(roomLocks){
       for(MeetingRoom meetingRoom:meetingRooms){
           Lock lock = roomLocks.get(meetingRoom);
           if (lock!= null && lock.getLockedBy().equals(user))
               roomLocks.remove(lock);
       }

    }

    }

    @Override
    public void unlockRoom(TimeSlot slot, MeetingRoom meetingRoom, User user) {

        Map<MeetingRoom,Lock> roomLocks =  locks.get(slot);

        if (roomLocks == null) return;

        synchronized(roomLocks){
                Lock lock = roomLocks.get(meetingRoom);
                if (lock!= null && lock.getLockedBy().equals(user))
                    roomLocks.remove(lock);
            }

        }

    @Override
    public boolean validateLock(TimeSlot slot, MeetingRoom meetingRoom, User user) {

        Map<MeetingRoom,Lock> roomLocks = locks.get(slot);

        if ( roomLocks == null)
            return false;

        synchronized (roomLocks){
        Lock seatLock = roomLocks.get(meetingRoom);
        return seatLock != null && !seatLock.isLockExpired()
                && seatLock.getLockedBy().equals(user);
        }
    }

    @Override
    public List<MeetingRoom> getLockedRooms(TimeSlot slot) {
        return List.of();
    }
}
