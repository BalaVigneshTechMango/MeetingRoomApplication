package com.meeting.room.request;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Id;

public class MeetingRoomRequestPojo {

	private String roomId;
	private String floor;
	private String block;
	private String whiteBoard;
	private String memberCapacity;
	private String projector;
	private String television;
	private String webcamera;
	private String acAvailability;

	private int availId;
	private Date meetingDate;
	private Time meetingStartTime;
	private Time meetingEndTime;
	private int noMembersAttending;
	private String ttsId;
	private String purpose;
	private int businessPartnerId;
	private Boolean deleted;
	private String slotId;

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public int getAvailId() {
		return availId;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public Time getMeetingStartTime() {
		return meetingStartTime;
	}

	public Time getMeetingEndTime() {
		return meetingEndTime;
	}

	public int getNoMembersAttending() {
		return noMembersAttending;
	}

	public String getTtsId() {
		return ttsId;
	}

	public String getPurpose() {
		return purpose;
	}

	public int getBusinessPartnerId() {
		return businessPartnerId;
	}

	public void setAvailId(int availId) {
		this.availId = availId;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public void setMeetingStartTime(Time meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}

	public void setMeetingEndTime(Time meetingEndTime) {
		this.meetingEndTime = meetingEndTime;
	}

	public void setNoMembersAttending(int noMembersAttending) {
		this.noMembersAttending = noMembersAttending;
	}

	public void setTtsId(String ttsId) {
		this.ttsId = ttsId;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public void setBusinessPartnerId(int businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

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

	public String getProjector() {
		return projector;
	}

	public String getTelevision() {
		return television;
	}

	public String getWebcamera() {
		return webcamera;
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

	public void setMemberCapacity(String memberCapacity) {
		this.memberCapacity = memberCapacity;
	}

	public void setProjector(String projector) {
		this.projector = projector;
	}

	public void setTelevision(String television) {
		this.television = television;
	}

	public void setWebcamera(String webcamera) {
		this.webcamera = webcamera;
	}

	public void setAcAvailability(String acAvailability) {
		this.acAvailability = acAvailability;
	}

}
