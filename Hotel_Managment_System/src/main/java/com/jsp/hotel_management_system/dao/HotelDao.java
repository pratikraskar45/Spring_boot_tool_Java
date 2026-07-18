package com.jsp.hotel_management_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotel_management_system.dto.Hotel;
import com.jsp.hotel_management_system.repo.HotelRepo;
@Repository
public class HotelDao {
	@Autowired
	private HotelRepo hotelRepo;
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepo.save(hotel);
		
	}
	public Hotel updateHotel(Hotel hotel) {
		return hotelRepo.save(hotel);
	}
	public Hotel deleteHotel(int hid) {
		if (hotelRepo.findById(hid).isPresent()) {
			Hotel hotel= hotelRepo.findById(hid).get();
			hotelRepo.delete(hotel);
			return hotel;
		} else {
			return null;
		}
	}
	public Hotel getHotelbyid(int hid) {
		if (hotelRepo.findById(hid).isPresent()) {
			return hotelRepo.findById(hid).get();
		}else {
			return null;
		}	
	}
	

}
