package com.interview.practice.service;

import com.interview.practice.domain.*;
import com.interview.practice.lock.ILockRoomProvider;
import com.interview.practice.repository.MeetingRepository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BookingService {


   private final Map<String, MeetingRoom>  meetingRoomreservations = new ConcurrentHashMap<>();
   private final ILockRoomProvider lockRoomProvider;
   private final RoomAvalabilityService roomAvalabilityService;
   private final AtomicInteger reservationIdCounter = new AtomicInteger(1);
    private final MeetingRepository meetingRepository;

   public BookingService(ILockRoomProvider roomProvider,RoomAvalabilityService roomAvalabilityService,MeetingRepository meetingRepository){
          this.lockRoomProvider = roomProvider;
          this.roomAvalabilityService = roomAvalabilityService;
          this.meetingRepository = meetingRepository;
   }

   public Meeting createBooking(final User organizer, MeetingRoom meetingRoom,final TimeSlot timeSlot,final List<User> participants) throws Exception {

  // Check if any requested seat is already locked

       if ( roomAvalabilityService.isRoomAvailable(meetingRoom,timeSlot))

       // Lock the seats temporarily for the user (this will throw an exception if any seat is already locked)
       lockRoomProvider.LockRooms(timeSlot,meetingRoom,organizer);

       // Create a new meeting with a unique booking ID using Atomic Integer

       String meetingId = String.valueOf(reservationIdCounter.getAndIncrement());

       Meeting newBooking = new Meeting(meetingId,meetingRoom,timeSlot,organizer,participants);

       return newBooking;
   }


   // Confirm booking

    public void confirmBooking(MeetingRoom meetingRoom,User user,TimeSlot timeSlot) throws Exception {

       if (!lockRoomProvider.validateLock(timeSlot,meetingRoom,user))
           throw new Exception("Lock is Expired");


        meetingRoom.setMeetingStatus(MeetingStatus.CONFIRMED);
      //  meetingRepository.update(meeting);

        lockRoomProvider.unlockRoom(
                timeSlot,
                meetingRoom,
                user);

    }



    // UNlock


}
