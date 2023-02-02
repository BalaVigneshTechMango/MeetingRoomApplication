package com.meeting.room.dao;

import java.util.List;

import com.meeting.room.entity.MeetingRoomsEntity;
import com.meeting.room.entity.RegisterMeetingEntity;
import com.meeting.room.request.MeetingRoomRequestPojo;

public interface MeetingRoomDao {

	List<MeetingRoomsEntity> getRoomDetails();

	void createRoom(MeetingRoomsEntity meetingRoomEntity);
	
	void registerMeetingRoom(RegisterMeetingEntity registerMeetingEntity);

	List<Object>  findByDate(MeetingRoomRequestPojo meetingRoomRequestPojo);

	void findByRoomId(MeetingRoomRequestPojo meetingRoomRequestPojo);

	void updateNoOfMembes(MeetingRoomRequestPojo meetingRoomRequestPojo);

	void deleteById(MeetingRoomRequestPojo meetingRoomRequestPojo);

	List<RegisterMeetingEntity> findMeetingBookedRoom();

	Iterable<RegisterMeetingEntity> findCancelMeeting(MeetingRoomRequestPojo meetingRoomRequestPojo);

}
