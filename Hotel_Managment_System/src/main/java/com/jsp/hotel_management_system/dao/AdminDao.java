package com.jsp.hotel_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotel_management_system.dto.Admin;
import com.jsp.hotel_management_system.repo.AdminRepo;



@Repository
public class AdminDao {
	@Autowired
	private AdminRepo adminRepo;
	
	public Admin saveAdmin(Admin admin){
		return adminRepo.save(admin);
		
	}
	public Admin updateAdmin(Admin admin ) {
		return adminRepo.save(admin);	
	}
//	public Admin deleteAdmin(Admin admin) {
//		 adminRepo.delete(admin);
//		 return admin;
//	}
	public Admin deleteAdmin(int aid) {
		if (adminRepo.findById(aid).isPresent()) {
			Admin admin =adminRepo.findById(aid).get();
			adminRepo.delete(admin);
			return admin;
		}else {
			return null;
		}
	}
	public Admin getAdminbyid(int aid) {
		if (adminRepo.findById(aid).isPresent()) {
			return adminRepo.findById(aid).get();
		} else {
			return null;
		}
		
	}
	public List<Admin> getallAdmins() {
		return adminRepo.findAll();
		
	}
	public Admin getAdminbyemail(String admin_email) {
		if (adminRepo.getAdminbyemail(admin_email)!=null) {
			return adminRepo.getAdminbyemail(admin_email);
		} else {
			return null;
		}
		
	}
	

}
