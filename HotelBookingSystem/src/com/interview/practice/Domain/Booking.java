package com.interview.practice.Domain;


import com.interview.practice.CommonEnum.BookingStatus;
import com.interview.practice.CommonEnum.RoomType;

import java.time.Instant;

public class Booking {

    private final String bookingId;

    private final String guestId;

    private final String hotelId;

    private final RoomType roomType;

    private final DateRange dateRange;

    private final int roomCount;

    private BookingStatus bookingStatus;

    private final Instant createdAt;

    private final Instant holdExpiryTime;

    public Booking(
            String bookingId,
            String guestId,
            String hotelId,
            RoomType roomType,
            DateRange dateRange,
            int roomCount,
            Instant holdExpiryTime
    ) {
        this.bookingId = bookingId;
        this.guestId = guestId;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.dateRange = dateRange;
        this.roomCount = roomCount;

        this.bookingStatus =
                BookingStatus.HOLD_CREATED;

        this.createdAt = Instant.now();

        this.holdExpiryTime =
                holdExpiryTime;
    }

    public void markPaymentPending() {

        if (bookingStatus
                != BookingStatus.HOLD_CREATED) {

            throw new IllegalStateException(
                    "Invalid booking transition"
            );
        }

        bookingStatus =
                BookingStatus.PAYMENT_PENDING;
    }

    public void confirm() {

        if (bookingStatus
                != BookingStatus.PAYMENT_PENDING) {

            throw new IllegalStateException(
                    "Booking cannot be confirmed"
            );
        }

        bookingStatus =
                BookingStatus.CONFIRMED;
    }

    public void expire() {

        if (bookingStatus
                == BookingStatus.HOLD_CREATED) {

            bookingStatus =
                    BookingStatus.EXPIRED;
        }
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public DateRange getDateRange() {
        return dateRange;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
}