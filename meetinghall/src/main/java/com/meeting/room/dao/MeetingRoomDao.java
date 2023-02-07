package com.meeting.room.dao;

import java.util.List;

import com.meeting.room.entity.MeetingRoomsEntity;
import com.meeting.room.entity.RegisterMeetingEntity;
import com.meeting.room.request.MeetingRoomRequestPojo;

public interface MeetingRoomDao {

	List<MeetingRoomsEntity> getRoomDetails();

	void createRoom(MeetingRoomRequestPojo meetingRoomRequestPojo);
	
	void registerMeetingRoom(MeetingRoomRequestPojo meetingRoomRequestPojo);

	//List<Object> findByDate(MeetingRoomRequestPojo meetingRoomRequestPojo);

	public MeetingRoomsEntity findByRoomId(MeetingRoomRequestPojo meetingRoomRequestPojo);

	void updateNoOfMembes(MeetingRoomRequestPojo meetingRoomRequestPojo);

	void deleteById(MeetingRoomRequestPojo meetingRoomRequestPojo);

	List<RegisterMeetingEntity> findMeetingBookedRoom();

	Iterable<RegisterMeetingEntity> findCancelMeeting(MeetingRoomRequestPojo meetingRoomRequestPojo);

	public List<RegisterMeetingEntity> findByDateAndRoomId(MeetingRoomRequestPojo meetingRoomRequestPojo);

	void updateStatus(MeetingRoomRequestPojo meetingRoomRequestPojo);

	List<RegisterMeetingEntity> findByTtsId(MeetingRoomRequestPojo meetingRoomRequestPojo);

	List<RegisterMeetingEntity> findAvailability(MeetingRoomRequestPojo meetingRoomRequestPojo);

}
