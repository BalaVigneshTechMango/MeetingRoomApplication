package com.meeting.room.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

//@Where annotation, we can't get the deleted product data in case we still want the deleted data to be accessible.
// An example of this is a user with administrator-level that has full access and can view the data that has been “deleted”.
@Entity
@Table(name = "room_availability")
@SQLDelete(sql = "UPDATE room_availability SET deleted = true WHERE avail_id=?")//we actually have turned it into a SQL update command that changes the deleted field value to true instead of deleting the data permanently.
//@Where(clause = "deleted=false")//will add a filter when we read the product data
@FilterDef(name = "deletedRegisterFilter",parameters = @ParamDef(name ="isDeleted", type = "boolean"))
@Filter(name = "deletedRegisterFilter",condition = "deleted = :isDeleted")//With these annotations we can dynamically add conditions as needed
public class RegisterMeetingEntity {
	@Id
	@Column(name = "avail_id")
	private int availId;
	@Column(name = "room_id")
	private String roomId;
	@Column(name = "meeting_date")
	private Date meetingDate;
	@Column(name = "meeting_start_time")
	private Time meetingStartTime;
	@Column(name = "meeting_end_time")
	private Time meetingEndTime;
	@Column(name = "no_members_attending")
	private int noMembersAttending;
	@Column(name = "tts_id")
	private String ttsId;
	@Column(name = "purpose")
	private String purpose;
	@Column(name = "business_partner_id")
	private int businessPartnerId;
	@Column(name = "deleted")
	private Boolean deleted =Boolean.FALSE;
	@Column(name = "slot_id")
	private String slotId;
	
	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public int getAvailId() {
		return availId;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getRoomId() {
		return roomId;
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

	public void setRoomId(String roomId) {
		this.roomId = roomId;
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

}
