package com.meeting.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.room.entity.MeetingRoomsEntity;
import com.meeting.room.entity.RegisterMeetingEntity;
import com.meeting.room.request.MeetingRoomRequestPojo;
import com.meeting.room.response.MeetingRoomResponsePojo;
import com.meeting.room.service.MeetingRoomService;

@RestController
@RequestMapping("/meetingRoom")
public class MeetingRoomController {

	@Autowired
	private MeetingRoomService meetingRoomService;

	@PostMapping("/createRoom") // creating Meeting Room with details of facility
	public MeetingRoomResponsePojo createRoom(@RequestBody MeetingRoomRequestPojo meetingRoomRequestPojo) {
		MeetingRoomResponsePojo meetingRoomResponsePojo = new MeetingRoomResponsePojo();
		meetingRoomService.createRoom(meetingRoomRequestPojo);
		meetingRoomResponsePojo.setObject(meetingRoomRequestPojo);
		return meetingRoomResponsePojo;
	}

	@PostMapping("/getRoomDetails") // get All created Rooms and details
	public List<MeetingRoomsEntity> getRoomDetails() {
		return meetingRoomService.getRoomDetails();
	}

	@PostMapping("/registerMeetingRoom") // register Meeting Room
	public MeetingRoomResponsePojo registerMeetingRoom(@RequestBody MeetingRoomRequestPojo meetingRoomRequestPojo) {
		MeetingRoomResponsePojo meetingRoomResponsePojo = new MeetingRoomResponsePojo();
		meetingRoomService.registerMeetingRoom(meetingRoomRequestPojo);
		meetingRoomResponsePojo.setObject(meetingRoomRequestPojo);
		return meetingRoomResponsePojo;
	}

	@PostMapping("findByDate") // find By Date haved room booked
	public List<Object> findByDate(@RequestBody MeetingRoomRequestPojo meetingRoomRequestPojo) {
		MeetingRoomResponsePojo meetingRoomResponsePojo = new MeetingRoomResponsePojo();
		return meetingRoomService.findByDate(meetingRoomRequestPojo);
//		meetingRoomResponsePojo.setObject(meetingRoomRequestPojo);
//		return meetingRoomResponsePojo;
	}

	@PostMapping("findByRoomId") // find by RoomId have booked
	public MeetingRoomResponsePojo findByRoomId(@RequestBody MeetingRoomRequestPojo meetingRoomRequestPojo) {
		MeetingRoomResponsePojo meetingRoomResponsePojo = new MeetingRoomResponsePojo();
		meetingRoomService.findByRoomId(meetingRoomRequestPojo);
		meetingRoomResponsePojo.setObject(meetingRoomRequestPojo);
		return meetingRoomResponsePojo;
	}

	@PostMapping("/updateNoOfMembers")
	public MeetingRoomResponsePojo updateNoOfMembers(@RequestBody MeetingRoomRequestPojo meetingRoomRequestPojo) {
		MeetingRoomResponsePojo meetingRoomResponsePojo = new MeetingRoomResponsePojo();
		meetingRoomService.updateNoOfMembers(meetingRoomRequestPojo);
		meetingRoomResponsePojo.setObject(meetingRoomRequestPojo);
		return meetingRoomResponsePojo;

	}

	@PostMapping("/deleteById") // deleting by id as Soft Delete
	public MeetingRoomResponsePojo deleteById(@RequestBody MeetingRoomRequestPojo meetingRoomRequestPojo) {
		MeetingRoomResponsePojo meetingRoomResponsePojo = new MeetingRoomResponsePojo();
		meetingRoomService.deleteById(meetingRoomRequestPojo);
		meetingRoomResponsePojo.setObject(meetingRoomRequestPojo);
		return meetingRoomResponsePojo;
	}

	@PostMapping("/findMeetingBookedRoom")
	public List<RegisterMeetingEntity> findMeetingBookedRoom() {
		MeetingRoomResponsePojo meetingRoomResponsePojo = new MeetingRoomResponsePojo();
		return meetingRoomService.findMeetingBookedRoom();
	}

	@PostMapping("/findCanelMeeting")
	public Iterable<RegisterMeetingEntity> findCancelMeeting(
			@RequestBody MeetingRoomRequestPojo meetingRoomRequestPojo) {
		MeetingRoomResponsePojo meetingRoomResponsePojo = new MeetingRoomResponsePojo();
		return meetingRoomService.findCancelMeeting(meetingRoomRequestPojo);
	}

}
