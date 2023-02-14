package com.meeting.room.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meetingRoom")
public class MeetingRoomsEntity {
    
	@Id
	@Column(name = "room_id")
	private String roomId;
	@Column(name = "floor")
	private String floor;
	@Column(name = "block")
	private String block;
	@Column(name = "white_board")
	private String whiteBoard;
	@Column(name = "member_capacity")
	private String memberCapacity;
	@Column(name = "projector")
	private String projector;
	@Column(name = "television")
	private String television;
	@Column(name = "web_camera")
	private String webCamera;
	@Column(name = "ac_availability")
	private String acAvailability;
	
	public String getRoomId() {
		return roomId;
	}
	public String getFloor() {
		return floor;
	}
	public String getBlock() {
		return block;
	}
	
	public String getMemberCapacity() {
		return memberCapacity;
	}
	public void setMemberCapacity(String memberCapacity) {
		this.memberCapacity = memberCapacity;
	}
	public String getProjector() {
		return projector;
	}
	public String getTelevision() {
		return television;
	}
	
	public String getAcAvailability() {
		return acAvailability;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	
	
	public String getWhiteBoard() {
		return whiteBoard;
	}
	public void setWhiteBoard(String whiteBoard) {
		this.whiteBoard = whiteBoard;
	}
	public void setProjector(String projector) {
		this.projector = projector;
	}
	public void setTelevision(String television) {
		this.television = television;
	}

	public void setAcAvailability(String acAvailability) {
		this.acAvailability = acAvailability;
	}
	public String getWebCamera() {
		return webCamera;
	}
	public void setWebCamera(String webCamera) {
		this.webCamera = webCamera;
	}
	
	
	
	
}
