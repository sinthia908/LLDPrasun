package com.interview.practice;

import com.interview.practice.Domain.Booking;
import com.interview.practice.Domain.DateRange;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(
            String[] args
    ) {

        ExecutorService executor =
                Executors
                        .newFixedThreadPool(10);

        DateRange stay =
                new DateRange(
                        LocalDate.of(
                                2026,
                                8,
                                10
                        ),
                        LocalDate.of(
                                2026,
                                8,
                                13
                        )
                );

        for (
                int i = 1;
                i <= 10;
                i++
        ) {

            int userNumber = i;

            executor.submit(() -> {

                try {

                    Booking booking =
                            bookingController
                                    .bookHotel(
                                            "USER_"
                                                    + userNumber,

                                            "HOTEL_101",

                                            RoomType.DELUXE,

                                            stay,

                                            1
                                    );

                    System.out.println(
                            "Booking successful: "
                                    + booking
                                    .getBookingId()
                    );

                } catch (
                        Exception exception
                ) {

                    System.out.println(
                            "Booking failed for "
                                    + userNumber
                    );
                }
            });
        }

        executor.shutdown();
    }
}