package com.meeting.room.service;

import java.util.List;
import com.meeting.room.entity.MeetingRoomsEntity;
import com.meeting.room.entity.RegisterMeetingEntity;
import com.meeting.room.request.MeetingRoomRequestPojo;

public interface MeetingRoomService {

	public void createRoom(MeetingRoomRequestPojo meetingRoomRequestPojo);

	public List<MeetingRoomsEntity> getRoomDetails();
									
	public void registerMeetingRoom(MeetingRoomRequestPojo meetingRoomRequestPojo);

	//public List<Object> findByDate(MeetingRoomRequestPojo meetingRoomRequestPojo);

	public MeetingRoomsEntity findByRoomId(MeetingRoomRequestPojo meetingRoomRequestPojo);

	public void updateNoOfMembers(MeetingRoomRequestPojo meetingRoomRequestPojo);

	public void deleteById(MeetingRoomRequestPojo meetingRoomRequestPojo);

	public List<RegisterMeetingEntity> findMeetingBookedRoom();

	public Iterable<RegisterMeetingEntity> findCancelMeeting(MeetingRoomRequestPojo meetingRoomRequestPojo);

	public List<RegisterMeetingEntity> findByDateAndRoomId(MeetingRoomRequestPojo meetingRoomRequestPojo);

	public List<RegisterMeetingEntity> findByTtsId(MeetingRoomRequestPojo meetingRoomRequestPojo);

	public Object findAvailability(MeetingRoomRequestPojo meetingRoomRequestPojo);

}
