package com.pr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.pr.dto.DoctorDto;
import com.pr.entities.Appointment;
import com.pr.entities.Doctor;
import com.pr.exceptions.DoctorNotFoundException;
import com.pr.repository.AppointmentRepo;
import com.pr.repository.DoctorRepo;

@Service
public class DoctorService {
//=================================================================================================================================
//=================================================================================================================================

	@Autowired
	private DoctorRepo doctorRepo;
	@Autowired
	private AppointmentRepo appointmentRepo;
//========================================================================================================================================
//========================================================================================================================================

	public ResponseEntity<String> registerDoctor(DoctorDto doctorDto) {
		Optional<Doctor> opt = doctorRepo.findByEmail(doctorDto.getEmail());
		if (opt.isPresent()) {
			// means dr already register
			return new ResponseEntity<String>("Doctor with email:" + doctorDto.getEmail() + " is already registerd",
					HttpStatus.OK);

		} else {
			// new dr registerd
			Doctor doctor = new Doctor();
			BeanUtils.copyProperties(doctorDto, doctor);
			doctorRepo.save(doctor);
			return new ResponseEntity<String>("Doctor with email:" + doctorDto.getEmail() + " is register succesfully",
					HttpStatus.CREATED);

		}

	}
//=================================================================================================================================
//=================================================================================================================================

	public ResponseEntity<String> loginDoctor(DoctorDto doctorDto) {
		Doctor doctor = doctorRepo.findByEmail(doctorDto.getEmail())
				.orElseThrow(() -> new DoctorNotFoundException("Doctor is not found"));

		if (doctor.getPassword().equals(doctorDto.getPassword())) {
			// if password match then only login the doctor
			return new ResponseEntity<String>("Doctor Login Succesfully", HttpStatus.OK);

		} else {
			// passowrd not match
			return new ResponseEntity<String>("Invalid Password", HttpStatus.BAD_REQUEST);

		}

	}
//=================================================================================================================================
//=================================================================================================================================


	public ResponseEntity<String> updateDoctor(DoctorDto doctorDto, Integer dr_id) {
		Doctor findDoctor = doctorRepo.findById(dr_id)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor is not found"));
		findDoctor.setDr_experience(doctorDto.getDr_experience());
		findDoctor.setDr_availability(doctorDto.getDr_availability());

		doctorRepo.save(findDoctor);
		return new ResponseEntity<String>(findDoctor.getDr_name() + " Updated Sucessfully", HttpStatus.OK);
	}
//=================================================================================================================================
//=================================================================================================================================

	public ResponseEntity<String> deleteDoctor(Integer dr_id) {
		Doctor doctor = doctorRepo.findById(dr_id)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor is not found"));
		doctorRepo.delete(doctor);
		return new ResponseEntity<String>(doctor.getDr_name() + "is Deleted Sucessfully", HttpStatus.OK);
	}
//=================================================================================================================================
//=================================================================================================================================


	public ResponseEntity<Doctor> getDoctorById(Integer dr_id) {
		Doctor doctor = doctorRepo.findById(dr_id)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor is not found"));

		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
//=================================================================================================================================
//=================================================================================================================================


	public ResponseEntity<List<Doctor>> getAllDoctore() {
		List<Doctor> doctors = doctorRepo.findAll();

		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
	}
//=================================================================================================================================
//=================================================================================================================================


	public ResponseEntity<List<Appointment>> getAllAppoitmentBydr_id(Integer dr_id, Integer pageNumber) {
		Doctor doctor = doctorRepo.findById(dr_id)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor is not found"));
		// Get paginated enquiries

		Page<Appointment> appointmentPage = appointmentRepo.findByDoctorId(dr_id, PageRequest.of(pageNumber - 1, 2));
		List<Appointment> appointments = appointmentPage.getContent();
		return new ResponseEntity<List<Appointment>>(appointments, HttpStatus.OK);
	}
//=================================================================================================================================
//=================================================================================================================================



}
