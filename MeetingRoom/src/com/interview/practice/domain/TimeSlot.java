package com.interview.practice.domain;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;

public class TimeSlot {

    private LocalDateTime start;
    private LocalDateTime end;

    public TimeSlot(LocalDateTime start, LocalDateTime end){
           this.start = start;
           this.end = end;
    }

    public boolean overlaps(TimeSlot other){
        return start.isBefore(other.end) && end.isAfter(other.start);
    }
}


