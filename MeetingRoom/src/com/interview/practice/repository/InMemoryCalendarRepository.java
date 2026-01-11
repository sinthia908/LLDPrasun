package com.interview.practice.repository;

import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;

import com.interview.practice.domain.Calendar;

public class InMemoryCalendarRepository extends CalendarRepository{

    private final ConcurrentHashMap<String, Calendar> calendars = new ConcurrentHashMap<>();

    /*@Override
    public Calendar getCalendar(String roomId) {
        return calendars.computeIfAbsent(roomId,id-> new Calendar() {
        });
    }*/

    @Override
    public void save(com.interview.practice.domain.Calendar calendar) {

    }
}
