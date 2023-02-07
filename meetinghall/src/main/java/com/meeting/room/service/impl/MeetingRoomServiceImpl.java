package com.meeting.room.service.impl;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
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
		String id = meetingRoomRepository.getRoomId(meetingRoomRequestPojo.getBlock());
		meetingRoomRequestPojo.setRoomId(id);
		 meetingRoomDao.createRoom(meetingRoomRequestPojo);
		
	}

	@Override
	public List<MeetingRoomsEntity> getRoomDetails() {
		return meetingRoomDao.getRoomDetails();
	}

	@Override
	public void registerMeetingRoom(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		Time startTime = meetingRoomRequestPojo.getMeetingStartTime();
		Time endTime = meetingRoomRequestPojo.getMeetingEndTime();
		List<RegisterMeetingEntity> date = registerMeetingRepository
				.findByMeetingDate(meetingRoomRequestPojo.getMeetingDate());
		
		for (RegisterMeetingEntity obj : date) {
			Time stTm = obj.getMeetingStartTime();
			Time enTime = obj.getMeetingEndTime();
			System.out.println("CHECK" + stTm);
			if (!stTm.before(startTime) && !stTm.equals(startTime)
					|| !startTime.before(enTime) && !startTime.equals(endTime) && endTime.after(startTime)
					|| date.isEmpty()) {
				meetingRoomRequestPojo.setBookingStatus("Booked");
				meetingRoomDao.registerMeetingRoom(meetingRoomRequestPojo);
           
			}
		}
		if (date.isEmpty()) {
			meetingRoomRequestPojo.setBookingStatus("Booked");
			meetingRoomRequestPojo.setDeleted(false);
			meetingRoomDao.registerMeetingRoom(meetingRoomRequestPojo);
		}
	}

//	@Override
//	public List<Object> findByDate(MeetingRoomRequestPojo meetingRoomRequestPojo) {
//		return meetingRoomDao.findByDate(meetingRoomRequestPojo);
//	}

	@Override
	public MeetingRoomsEntity findByRoomId(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		return meetingRoomDao.findByRoomId(meetingRoomRequestPojo);

	}

	@Override
	public void updateNoOfMembers(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		meetingRoomDao.updateNoOfMembes(meetingRoomRequestPojo);
	}

	@Override
	public void deleteById(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		meetingRoomDao.updateStatus(meetingRoomRequestPojo);
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

	@Override
	public List<RegisterMeetingEntity> findByDateAndRoomId(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		return meetingRoomDao.findByDateAndRoomId(meetingRoomRequestPojo);

	}

	@Override
	public List<RegisterMeetingEntity> findByTtsId(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		return meetingRoomDao.findByTtsId(meetingRoomRequestPojo);
	}

	@Override
	public Object findAvailability(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		List<Object> obj = new ArrayList<>();
		Time temp = null;
		LocalTime startingTime = LocalTime.of(01, 00, 00);
		LocalTime endingTime = LocalTime.of(23, 59, 59);
		List<RegisterMeetingEntity> aObject = meetingRoomDao.findAvailability(meetingRoomRequestPojo);
		for (RegisterMeetingEntity registerMeetingEntity : aObject) {
			Time dbStarting = registerMeetingEntity.getMeetingStartTime();
			Time dbEndingTime = registerMeetingEntity.getMeetingEndTime();
			if (temp == null && !startingTime.equals(dbStarting)) {
				obj.add("From: " + startingTime + " To: " + dbStarting + " Available ");
			} else if (!temp.equals(dbStarting)) {
				obj.add("From: " + temp + " TO: " + dbStarting + " Available ");
			} else {
				obj.add("From:" + dbEndingTime + " TO: " + endingTime + " Available ");
			}
			temp = dbEndingTime;
		}
		return obj;

	}

}
