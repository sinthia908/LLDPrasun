package com.interview.practice.Services;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class BookingService {

    private final InventoryService
            inventoryService;

    private final BookingRepository
            bookingRepository;

    public BookingService(
            InventoryService inventoryService,
            BookingRepository bookingRepository
    ) {
        this.inventoryService =
                inventoryService;

        this.bookingRepository =
                bookingRepository;
    }

    public Booking createBookingHold(
            String guestId,
            String hotelId,
            RoomType roomType,
            DateRange dateRange,
            int roomCount
    ) {

        String bookingId =
                UUID.randomUUID()
                        .toString();

        inventoryService.createHold(
                hotelId,
                roomType,
                dateRange,
                roomCount
        );

        Booking booking =
                new Booking(
                        bookingId,
                        guestId,
                        hotelId,
                        roomType,
                        dateRange,
                        roomCount,
                        Instant.now()
                                .plus(
                                        Duration
                                                .ofMinutes(10)
                                )
                );

        bookingRepository.save(
                booking
        );

        return booking;
    }
}