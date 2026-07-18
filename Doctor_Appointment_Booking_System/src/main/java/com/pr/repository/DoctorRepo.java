package com.pr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pr.entities.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
	Optional<Doctor> findByEmail(String email); 
}
