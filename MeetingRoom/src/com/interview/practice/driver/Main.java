package com.interview.practice.driver;

import com.interview.practice.domain.MeetingRoom;
import com.interview.practice.lock.ILockRoomProvider;
import com.interview.practice.lock.RoomLockProvider;
import com.interview.practice.repository.InMemoryMeetingRepository;
import com.interview.practice.repository.MeetingRepository;
import com.interview.practice.service.BookingService;
import com.interview.practice.service.RoomAvalabilityService;


public class Main {

    public static void main(String args[]){

        ILockRoomProvider lockRoomProvider = new RoomLockProvider(600);
        RoomAvalabilityService roomAvalabilityService = new RoomAvalabilityService();
        MeetingRepository meetingRepository = new InMemoryMeetingRepository();

        BookingService bookingService = new BookingService(lockRoomProvider,roomAvalabilityService,meetingRepository);


        // Add meeting rooms







    }
}
