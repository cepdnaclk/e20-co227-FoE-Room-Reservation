package com.ketha.FoE_RoomReservation.service.interfac;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import com.ketha.FoE_RoomReservation.dto.ResponseDto;
import com.ketha.FoE_RoomReservation.model.Booking.RecurrenceType;
import com.ketha.FoE_RoomReservation.model.Room;

public interface RoomService {

	ResponseDto getAllRooms();
	
	ResponseDto getRoomById(int roomId);
	
	ResponseDto getAvailableRoomsByDate(Time startTime, Time endTime, Date date);
	
	ResponseDto addRoom(int capacity, String roomName, String description);
	
	ResponseDto deleteRoom(int roomId);
	
	ResponseDto updateRoom(int roomId, Integer capacity, String roomName, String description);
	
}