package com.pr.counsellorapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pr.counsellorapp.entity.Counsellor;

public interface CounsellorRepository extends JpaRepository<Counsellor, Integer> {

	Optional<Counsellor> findByEmail(String email);

	Optional<Counsellor> findByEmailAndPassword(String email, String password);	


}
