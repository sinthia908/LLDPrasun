package com.interview.practice.Interfaces;

import com.interview.practice.Domain.Booking;
import com.interview.practice.Domain.RoomInventory;

import java.util.List;

public interface IBookingRepository {

    void save(Booking booking);

    Booking findById(String bookingId);

    List<Booking> findByGuestId(String guestId);

}
