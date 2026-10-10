package com.interview.practice.Domain;

import java.time.LocalDate;

public class DateRange {

    private final LocalDate checkIn;
    private final LocalDate checkOut;

    public DateRange(
            LocalDate checkIn,
            LocalDate checkOut
    ) {

        if (checkIn == null
                || checkOut == null) {

            throw new IllegalArgumentException(
                    "Dates cannot be null"
            );
        }

        if (!checkIn.isBefore(checkOut)) {

            throw new IllegalArgumentException(
                    "Check-out must be after check-in"
            );
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}
