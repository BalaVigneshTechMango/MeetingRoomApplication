package com.meeting.room.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeting.room.dao.MeetingRoomDao;
import com.meeting.room.entity.MeetingRoomsEntity;
import com.meeting.room.entity.RegisterMeetingEntity;
import com.meeting.room.repository.MeetingRoomRepository;
import com.meeting.room.repository.RegisterMeetingRepository;
import com.meeting.room.request.MeetingRoomRequestPojo;
import com.meeting.room.service.MeetingRoomService;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {
	@Autowired
	private MeetingRoomRepository meetingRoomRepository;
	@Autowired
	private MeetingRoomDao meetingRoomDao;
	@Autowired
	private RegisterMeetingRepository registerMeetingRepository;
	
	@Override
	public void createRoom(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		MeetingRoomsEntity meetingRoomEntity = new MeetingRoomsEntity();
		String id = meetingRoomRepository.getRoomId(meetingRoomRequestPojo.getBlock());
		meetingRoomEntity.setRoomId(id);
		meetingRoomEntity.setBlock(meetingRoomRequestPojo.getBlock());
		meetingRoomEntity.setFloor(meetingRoomRequestPojo.getFloor());
		meetingRoomEntity.setWhiteBoard(meetingRoomRequestPojo.getWhiteBoard());
		meetingRoomEntity.setMemberCapacity(meetingRoomRequestPojo.getMemberCapacity());
		meetingRoomEntity.setProjector(meetingRoomRequestPojo.getProjector());
		meetingRoomEntity.setTelevision(meetingRoomRequestPojo.getTelevision());
		meetingRoomEntity.setWebcamera(meetingRoomRequestPojo.getWebcamera());
		meetingRoomEntity.setAcAvailability(meetingRoomRequestPojo.getAcAvailability());
		meetingRoomDao.createRoom(meetingRoomEntity);
	}

	@Override
	public List<MeetingRoomsEntity> getRoomDetails() {
		return meetingRoomDao.getRoomDetails();
	}

	@Override
	public void registerMeetingRoom(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		//Date date=registerMeetingRepository.findByMeetingDate(meetingRoomRequestPojo.getMeetingDate());
		
		
		 Instant start = Instant.now();
		 // time passes      
		 Instant end = Instant.now();
		 Duration timeElapsed = Duration.between(start, end); 
		
		RegisterMeetingEntity registerMeetingEntity=new RegisterMeetingEntity();
		registerMeetingEntity.setRoomId(meetingRoomRequestPojo.getRoomId());
		registerMeetingEntity.setMeetingDate(meetingRoomRequestPojo.getMeetingDate());
		registerMeetingEntity.setMeetingStartTime(meetingRoomRequestPojo.getMeetingStartTime());
		registerMeetingEntity.setMeetingEndTime(meetingRoomRequestPojo.getMeetingEndTime());
		registerMeetingEntity.setNoMembersAttending(meetingRoomRequestPojo.getNoMembersAttending());
		registerMeetingEntity.setTtsId(meetingRoomRequestPojo.getTtsId());
		registerMeetingEntity.setPurpose(meetingRoomRequestPojo.getPurpose());
		registerMeetingEntity.setBusinessPartnerId(meetingRoomRequestPojo.getBusinessPartnerId());
		registerMeetingEntity.setSlotId(meetingRoomRequestPojo.getSlotId());
		meetingRoomDao.registerMeetingRoom(registerMeetingEntity);
	}

	@Override
	public List<Object> findByDate(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		return meetingRoomDao.findByDate(meetingRoomRequestPojo);
	}

	@Override
	public void findByRoomId(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		meetingRoomDao.findByRoomId(meetingRoomRequestPojo);
		
	}

	@Override
	public void updateNoOfMembers(MeetingRoomRequestPojo meetingRoomRequestPojo) {
	   meetingRoomDao.updateNoOfMembes(meetingRoomRequestPojo);	
	}

	@Override
	public void deleteById(MeetingRoomRequestPojo meetingRoomRequestPojo) {
	   meetingRoomDao.deleteById(meetingRoomRequestPojo);
	}

	@Override
	public List<RegisterMeetingEntity> findMeetingBookedRoom() {
		return meetingRoomDao.findMeetingBookedRoom();
		
	}

	@Override
	public Iterable<RegisterMeetingEntity> findCancelMeeting(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		return meetingRoomDao.findCancelMeeting(meetingRoomRequestPojo);
	}

    	
	
}
