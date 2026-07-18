package com.jsp.hotel_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotel_management_system.dto.Booking;
import com.jsp.hotel_management_system.repo.BookingRepo;
@Repository
public class BookingDao {
	@Autowired
	private BookingRepo bookingRepo;
	
	public Booking saveBooking(Booking booking) {
		return bookingRepo.save(booking);
	}
	public Booking updateBooking(Booking booking) {
		return bookingRepo.save(booking);
	}
	public Booking deleteBooking(Booking booking) {
		bookingRepo.delete(booking);
		return booking;
	}
	public Booking getBookingbyid(int bid) {
		if (bookingRepo.findById(bid).isPresent()) {
			return bookingRepo.findById(bid).get();			
		} else {
			return null;
		}
		
	}
	public List<Booking> getallBookings() {
		return bookingRepo.findAll();
	}
	public Booking getBookingbycheckindate(String checkindate) {
		if (bookingRepo.getBookingbycheckindate(checkindate)!=null) {
			return bookingRepo.getBookingbycheckindate(checkindate);
		}else {
			return null;
		}
	}
	public Booking getBookingbycheckoutdate(String checkoutdate) {
		if (bookingRepo.getBookingbycheckoutdate(checkoutdate)!=null) {
			return bookingRepo.getBookingbycheckoutdate(checkoutdate);
		}else {
			return null;
		}
		
	}

}
