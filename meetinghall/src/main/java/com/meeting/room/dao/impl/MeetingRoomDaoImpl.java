package com.meeting.room.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.meeting.room.dao.MeetingRoomDao;
import com.meeting.room.entity.MeetingRoomsEntity;
import com.meeting.room.entity.RegisterMeetingEntity;
import com.meeting.room.repository.RegisterMeetingRepository;
import com.meeting.room.request.MeetingRoomRequestPojo;

@Service
public class MeetingRoomDaoImpl implements MeetingRoomDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private RegisterMeetingRepository registerMeetingRepository;
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<MeetingRoomsEntity> getRoomDetails() {
		List<MeetingRoomsEntity> res = jdbcTemplate.query("SELECT * from meeting_room",
				BeanPropertyRowMapper.newInstance(MeetingRoomsEntity.class));
		return res;
		
	}

	@Override
	public void createRoom(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		jdbcTemplate.update(
				"INSERT INTO meeting_room(room_id,floor,block,white_board,member_capacity,projector,television,web_camera,ac_availability) "
						+ "VALUES(?,?,?,?,?,?,?,?,?)",
				new Object[] { meetingRoomRequestPojo.getRoomId(), meetingRoomRequestPojo.getFloor(),
						meetingRoomRequestPojo.getBlock(), meetingRoomRequestPojo.getWhiteBoard(),
						meetingRoomRequestPojo.getMemberCapacity(), meetingRoomRequestPojo.getProjector(),
						meetingRoomRequestPojo.getTelevision(), meetingRoomRequestPojo.getWebcamera(),
						meetingRoomRequestPojo.getAcAvailability() });

	}

	@Override
	public void registerMeetingRoom(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		jdbcTemplate.update(
				"INSERT INTO room_availability (room_id,meeting_date,meeting_start_time,meeting_end_time,no_members_attending,tts_id,"
						+ "purpose,business_partner_id,deleted,booking_status)VALUES(?,?,?,?,?,?,?,?,?,?)",
				new Object[] { meetingRoomRequestPojo.getRoomId(), meetingRoomRequestPojo.getMeetingDate(),
						meetingRoomRequestPojo.getMeetingStartTime(), meetingRoomRequestPojo.getMeetingEndTime(),
						meetingRoomRequestPojo.getNoMembersAttending(),meetingRoomRequestPojo.getTtsId(),
						meetingRoomRequestPojo.getPurpose(), meetingRoomRequestPojo.getBusinessPartnerId(),
						meetingRoomRequestPojo.getDeleted(), meetingRoomRequestPojo.getBookingStatus() });
	}

//	@Override
//	public List<Object>  findByDate(MeetingRoomRequestPojo meetingRoomRequestPojo) {
//		return registerMeetingRepository.findByMeetingDate(meetingRoomRequestPojo.getMeetingDate());
//	}

	@Override
	public MeetingRoomsEntity findByRoomId(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		return jdbcTemplate.queryForObject("Select * from  room_availability where room_id=?",
				BeanPropertyRowMapper.newInstance(MeetingRoomsEntity.class), meetingRoomRequestPojo.getRoomId());

	}

	@Override
	public void updateNoOfMembes(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		jdbcTemplate.update("UPDATE room_availability SET no_members_attending=? where avail_id=?",
				new Object[] { meetingRoomRequestPojo.getNoMembersAttending(), meetingRoomRequestPojo.getAvailId() });
	}

	@Override
	public void deleteById(MeetingRoomRequestPojo meetingRoomRequestPojo) {
//		jdbcTemplate.update("DELETE from room_availability Where avail_id=?", meetingRoomRequestPojo.getAvailId());
		registerMeetingRepository.deleteById(meetingRoomRequestPojo.getAvailId());
	}

	@Override
	public List<RegisterMeetingEntity> findMeetingBookedRoom() {
		return jdbcTemplate.query("SELECT * from room_availability",
				BeanPropertyRowMapper.newInstance(RegisterMeetingEntity.class));
	}

	@Override
	public Iterable<RegisterMeetingEntity> findCancelMeeting(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		Boolean isDeleted = meetingRoomRequestPojo.getDeleted();
		System.out.println(isDeleted);
		Session session = entityManager.unwrap(Session.class);
		org.hibernate.Filter filter = session.enableFilter("deletedRegisterFilter");
		filter.setParameter("isDeleted", isDeleted);
		Iterable<RegisterMeetingEntity> register = registerMeetingRepository.findAll();
		session.disableFilter("deletedRegisterFilter");
		return register;
	}

	@Override
	public List<RegisterMeetingEntity> findByDateAndRoomId(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		return registerMeetingRepository.findByMeetingDateAndRoomId(meetingRoomRequestPojo.getMeetingDate(),
				meetingRoomRequestPojo.getRoomId());
	}

	@Override
	public void updateStatus(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		jdbcTemplate.update("UPDATE room_availability SET booking_status=? Where avail_id=?",
				new Object[] { meetingRoomRequestPojo.getBookingStatus(), meetingRoomRequestPojo.getAvailId() });
	}

	@Override
	public List<RegisterMeetingEntity> findByTtsId(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		return jdbcTemplate.query("SELECT * from room_availability where tts_id=?",
				BeanPropertyRowMapper.newInstance(RegisterMeetingEntity.class), meetingRoomRequestPojo.getTtsId());
	}

	@Override
	public List<RegisterMeetingEntity> findAvailability(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		return jdbcTemplate.query(
				"SELECT * from room_availability where meeting_date=? AND room_id=? order by meeting_start_time asc",
				BeanPropertyRowMapper.newInstance(RegisterMeetingEntity.class), meetingRoomRequestPojo.getMeetingDate(),
				meetingRoomRequestPojo.getRoomId());
	}

	@Override
	public void rescheduleTime(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		jdbcTemplate.update("UPDATE room_availability SET meeting_start_time=?, meeting_end_time=? where avail_id=? ",
				new Object[] { meetingRoomRequestPojo.getMeetingStartTime(), meetingRoomRequestPojo.getMeetingEndTime(),
						meetingRoomRequestPojo.getAvailId() });

	}

	@Override
	public List<RegisterMeetingEntity> findRoomIdBySchedule(MeetingRoomRequestPojo meetingRoomRequestPojo) {
		
		return jdbcTemplate.query("SELECT * from room_availability where avail_id=?",
				BeanPropertyRowMapper.newInstance(RegisterMeetingEntity.class),meetingRoomRequestPojo.getAvailId());
	}

}
