package com.meeting.room.exception;

public class RoomNotFoundException extends RuntimeException {

	
	public RoomNotFoundException() {
		
		super(String.format("Meeting room for this time not available"));
	}
}
