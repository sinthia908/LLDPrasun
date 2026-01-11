package com.interview.practice.repository;

import com.interview.practice.domain.Meeting;

import java.util.List;

public interface MeetingRepository {

   void save(Meeting meeting);

   List<Meeting> findByUser(String roomId);

   List<Meeting> findByRoom(String userId);


}
