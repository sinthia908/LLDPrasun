package com.interview.practice.Controllers;

import com.interview.practice.CommonEnum.RoomType;
import com.interview.practice.Domain.Booking;
import com.interview.practice.Domain.DateRange;
import com.interview.practice.Services.BookingService;

public class HotelBookingController {

    private final BookingService
            bookingService;

    public HotelBookingController(
            BookingService bookingService
    ) {
        this.bookingService =
                bookingService;
    }

    public Booking bookHotel(
            String guestId,
            String hotelId,
            RoomType roomType,
            DateRange dateRange,
            int roomCount
    ) {

        return bookingService
                .createBookingHold(
                        guestId,
                        hotelId,
                        roomType,
                        dateRange,
                        roomCount
                );
    }
}
