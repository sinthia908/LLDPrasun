package com.interview.practice.driver;

import com.interview.practice.domain.MeetingRoom;
import com.interview.practice.domain.TimeSlot;
import com.interview.practice.domain.User;
import com.interview.practice.lock.ILockRoomProvider;
import com.interview.practice.lock.RoomLockProvider;
import com.interview.practice.repository.InMemoryMeetingRepository;
import com.interview.practice.repository.MeetingRepository;
import com.interview.practice.service.BookingService;
import com.interview.practice.service.RoomAvalabilityService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


public class Main {

    public static void main(String args[]) throws Exception {

        ILockRoomProvider lockRoomProvider = new RoomLockProvider(600);
        MeetingRepository meetingRepository = new InMemoryMeetingRepository();
        RoomAvalabilityService roomAvalabilityService = new RoomAvalabilityService(meetingRepository);
        BookingService bookingService = new BookingService(lockRoomProvider,roomAvalabilityService,meetingRepository);

        // Add meeting rooms

        User user1 = new User("101","Prasun Majumder","prasunmazumder@gmail.com",953867);
        User user2 = new User("102","Ricky Majumder","prasunmazumder@gmail.com",953867);

        LocalDate today = LocalDate.now();

        LocalDateTime start = LocalDateTime.of(today, LocalTime.of(10,0));
        LocalDateTime end = LocalDateTime.of(today,LocalTime.of(11,0));

        System.out.print("Adding Meeting Rooms ...");

        // Set up all rooms and employees
        MeetingRoom meetingRoom1 = new MeetingRoom("R001","Conference Room A",10);
        MeetingRoom meetingRoom2 = new MeetingRoom("R002","Conference Room B",10);
        MeetingRoom meetingRoom3 = new MeetingRoom("R003","Conference Room C",10);

       // Creating a booking for a time slot from 10 to 11
        bookingService.createBooking(user1,meetingRoom1,new TimeSlot(start,end), List.of(user2));
       // Creating another booking for same time slot for a different user
        bookingService.createBooking(user2,meetingRoom1,new TimeSlot(start,end), List.of(user1));

    }
}
