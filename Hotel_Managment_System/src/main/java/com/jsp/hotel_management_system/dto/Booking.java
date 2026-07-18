package com.jsp.hotel_management_system.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
	private LocalDateTime checkindate;
	private LocalDateTime checkoutdate;
	private int no_people;
	private int rating;
	@ManyToOne
	private Customer customer;
	@OneToOne
	private Room room;
}
