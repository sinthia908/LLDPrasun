package com.interview.practice.repository;

import com.interview.practice.domain.Meeting;
import com.interview.practice.domain.MeetingRoom;

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
    public void update(Meeting meeting) {
        for(int i=0 ; i < meetingList.size() ; i++){
            if (meetingList.get(i).getMeetingId() == meeting.getMeetingId())
                meetingList.set(i,meeting);
                return ;
        }
    }

    @Override
    public List<Meeting> findByUser(String roomId) {
        return List.of();
    }

    @Override
    public List<Meeting> findByRoom(String roomId) {
        ArrayList<Meeting> meetings = new ArrayList<>();

        for(Meeting meetingRoom: meetingList){
            if (meetingRoom.getMeetingRoom().getMeetingRoomid().equals(roomId))
                meetings.add(meetingRoom);
        }
        return meetings;
    }
}
