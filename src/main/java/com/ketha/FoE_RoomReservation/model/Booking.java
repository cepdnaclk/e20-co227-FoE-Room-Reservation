package com.ketha.FoE_RoomReservation.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.ketha.FoE_RoomReservation.model.User.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	private Time startTime;
	private Time endTime;
	private Date date;
	@Enumerated(EnumType.STRING)
	private RecurrenceType recurrence;
	private int recurrencePeriod;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eventId")
	private Event event;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomId")
	private Room room;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	private User user;
	
	public enum RecurrenceType {none, daily, weekly};
}
