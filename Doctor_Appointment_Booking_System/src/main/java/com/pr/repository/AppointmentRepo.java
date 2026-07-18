package com.pr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pr.entities.Appointment;

public interface AppointmentRepo extends  JpaRepository<Appointment, Integer> {

	Page<Appointment> findByDoctorId(Integer dr_id, Pageable pageable);
}
