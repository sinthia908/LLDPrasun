package com.interview.practice.repository;

import com.interview.practice.domain.Meeting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InMemoryMeetingRepository implements MeetingRepository {

    List<Meeting> meetingList = new ArrayList<>();

    @Override
    public void save(Meeting meeting) {
        meetingList.add(meeting);

    }

    @Override
    public List<Meeting> findByUser(String roomId) {
        return List.of();
    }

    @Override
    public List<Meeting> findByRoom(String userId) {
        return List.of();
    }
}
