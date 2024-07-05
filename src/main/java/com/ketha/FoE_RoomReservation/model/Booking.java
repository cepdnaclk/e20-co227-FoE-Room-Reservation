package com.ketha.FoE_RoomReservation.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private Time startTime;
	private Time endTime;
	private Date date;
	@Enumerated(EnumType.STRING)
	private RecurrenceType recurrence;
	private int recurrencePeriod;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomId")
	private Room roomId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	private User userId;
	
	public enum RecurrenceType {none, daily, weekly};
	
	public Booking() {
		
	}
	
	public Booking(Time startTime, Time endTime, Date date, RecurrenceType recurrence, int recurrencePeriod, Room roomId, User userId) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.recurrence = recurrence;
		this.recurrencePeriod = recurrencePeriod;
		this.roomId = roomId;
		this.userId = userId;
	}
	
	public int getBookingId() {
		return bookingId;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public Date getDate() {
		return date;
	}

	public int getRecurrencePeriod() {
		return recurrencePeriod;
	}

	public Room getRoomId() {
		return roomId;
	}

	public User getUserId() {
		return userId;
	}
}