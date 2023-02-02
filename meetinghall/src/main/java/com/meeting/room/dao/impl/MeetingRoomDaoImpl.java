package com.meeting.room.dao.impl;
import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meeting.room.dao.MeetingRoomDao;
import com.meeting.room.entity.MeetingRoomsEntity;
import com.meeting.room.entity.RegisterMeetingEntity;
import com.meeting.room.repository.MeetingRoomRepository;
import com.meeting.room.repository.RegisterMeetingRepository;
import com.meeting.room.request.MeetingRoomRequestPojo;

@Service
public class MeetingRoomDaoImpl implements MeetingRoomDao {

	@Autowired
	private MeetingRoomRepository meetingRoomRepository;
    @Autowired
	private RegisterMeetingRepository registerMeetingRepository;
    @Autowired
    private EntityManager entityManager;
	@Override
	public List<MeetingRoomsEntity> getRoomDetails() {
		return meetingRoomRepository.findAll();
	}

	@Override
	public void createRoom(MeetingRoomsEntity meetingRoomEntity) {
		meetingRoomRepository.save(meetingRoomEntity);
	}

	@Override
	public void registerMeetingRoom(RegisterMeetingEntity registerMeetingEntity) {
		 registerMeetingRepository.save(registerMeetingEntity);
	}

	@Override
	public List<Object>  findByDate(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		return registerMeetingRepository.findByMeetingDate(meetingRoomRequestPojo.getMeetingDate());
	}

	@Override
	public void findByRoomId(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		registerMeetingRepository.findByRoomId(meetingRoomRequestPojo.getRoomId());
	}

	@Override
	public void updateNoOfMembes(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		
		registerMeetingRepository.updateNoOfMembers(meetingRoomRequestPojo.getAvailId(), meetingRoomRequestPojo.getNoMembersAttending());
	}

	@Override
	public void deleteById(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		registerMeetingRepository.deleteById(meetingRoomRequestPojo.getAvailId());
	}

	@Override
	public List<RegisterMeetingEntity> findMeetingBookedRoom() {
		return registerMeetingRepository.findAll();	
	}
	@Override
	public Iterable<RegisterMeetingEntity> findCancelMeeting(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		Boolean isDeleted=meetingRoomRequestPojo.getDeleted();
		System.out.println(isDeleted);
		Session session = entityManager.unwrap(Session.class);
		org.hibernate.Filter filter = session.enableFilter("deletedRegisterFilter");
        filter.setParameter("isDeleted",isDeleted);
        Iterable<RegisterMeetingEntity> register =  registerMeetingRepository.findAll();
        session.disableFilter("deletedRegisterFilter");
		return register;
	}
	
	

}
