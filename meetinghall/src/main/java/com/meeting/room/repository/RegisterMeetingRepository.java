package com.meeting.room.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meeting.room.entity.RegisterMeetingEntity;
import com.meeting.room.request.MeetingRoomRequestPojo;
@Repository
public interface RegisterMeetingRepository extends JpaRepository<RegisterMeetingEntity, Integer> {

	public void findByRoomId(String roomId);

	public List<Object> findByMeetingDate(Date meetingDate);
	
	@Modifying
	@Transactional
	@Query("UPDATE RegisterMeetingEntity r Set r.noMembersAttending= :noMembersAttending where r.availId= :availId")
	public void updateNoOfMembers(int availId, @Param("noMembersAttending") int noMembersAttending);

	
}
