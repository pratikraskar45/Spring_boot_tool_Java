package com.pr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pr.repository.AppointmentRepo;
import com.pr.repository.DoctorRepo;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepo appointmentRepo;
	@Autowired
	private  DoctorRepo doctorRepo ;

}
