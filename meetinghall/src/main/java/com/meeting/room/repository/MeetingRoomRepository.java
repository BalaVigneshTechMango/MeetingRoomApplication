package com.meeting.room.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meeting.room.entity.MeetingRoomsEntity;

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoomsEntity, String>{
	@Transactional
    @Procedure(procedureName = "generateroomId", outputParameterName = "rId")
    String getRoomId(@Param("blockname")String blockname);
}
