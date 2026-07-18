package com.jsp.hotel_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotel_management_system.dto.Room;
import com.jsp.hotel_management_system.repo.RoomRepo;
@Repository
public class RoomDao {
	@Autowired
	private RoomRepo roomRepo;
	
	public Room saveRoom(Room room) {
		return roomRepo.save(room);
	}
	public Room updateRoom(Room room) {
		return roomRepo.save(room);
	}
	public Room deleteRoom(int rid) {
		if (roomRepo.findById(rid).isPresent()) {
			Room room= roomRepo.findById(rid).get();
			roomRepo.delete(room);
			return room;
		}else {
			return null;
		}
	}
	public Room getRoombyid(int rid) {
		if (roomRepo.findById(rid).isPresent()) {
			return roomRepo.findById(rid).get();
		} else {
			return null;
		}
	}
	public List<Room> getallRooms() {
		return roomRepo.findAll();
		
	}
	public Room getroombyno(String room_no) {
		if (roomRepo.getroombyno(room_no)!=null) {
			return roomRepo.getroombyno(room_no);
		} else {
			return null;

		}		
	}
	public List<Room> getRoomsbytype(String room_type) {
		if (roomRepo.getRoombyroomtype(room_type)!=null) {
			return roomRepo.getRoombyroomtype(room_type);
		} else {
			return null;
		}
		
	}
	public List<Room> getRoomsnyavaliability(String availability) {
		if (roomRepo.getRoomsbyavailability(availability)!=null) {
			return roomRepo.getRoomsbyavailability(availability);
		} else {
			return null;

		}
		
	}

}
