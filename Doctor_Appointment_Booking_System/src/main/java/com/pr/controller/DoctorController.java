package com.pr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import com.pr.dto.DoctorDto;
import com.pr.entities.Appointment;
import com.pr.entities.Doctor;
import com.pr.service.AppointmentService;
import com.pr.service.DoctorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/dr")
public class DoctorController {
	
//=================================================================================================================================
//=================================================================================================================================

	@Autowired
	private DoctorService doctorService;
	@Autowired
	private AppointmentService appointmentService;
//=================================================================================================================================
//=================================================================================================================================

	
	@PostMapping("/register")
	public ResponseEntity<String> registerDoctor(@RequestBody DoctorDto doctorDto) {
		return doctorService.registerDoctor(doctorDto);

	}

//=================================================================================================================================
//=================================================================================================================================

	@PostMapping("/login")
	public ResponseEntity<String> loginDoctor(@RequestBody DoctorDto doctorDto) {
		return doctorService.loginDoctor(doctorDto);
	}
//=================================================================================================================================
//=================================================================================================================================

	@PutMapping("/update/{dr_id}")
	public ResponseEntity<String> updateDoctor(@PathVariable Integer dr_id, @RequestBody DoctorDto doctorDto) {

		return doctorService.updateDoctor(doctorDto, dr_id);
	}
//=================================================================================================================================
//=================================================================================================================================

	@DeleteMapping("/delete/{dr_id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable Integer dr_id) {
		return doctorService.deleteDoctor(dr_id);
	}
//=================================================================================================================================
//=================================================================================================================================

	@GetMapping("/doctor/{dr_id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer dr_id) {
		return doctorService.getDoctorById(dr_id);

	}
//=================================================================================================================================
//=================================================================================================================================

	@GetMapping("/getallDoctor")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		return doctorService.getAllDoctore();
	}
//=================================================================================================================================
//=================================================================================================================================

	// get all appointment by dr_id
	@GetMapping("/appoitment/{dr_id}")
	public ResponseEntity<List<Appointment>> getAllAppoitmentBydr_id(@PathVariable Integer dr_id,
			@RequestParam Integer pageNumber) {
		return doctorService.getAllAppoitmentBydr_id(dr_id, pageNumber);
	}
//=================================================================================================================================
//=================================================================================================================================


}
