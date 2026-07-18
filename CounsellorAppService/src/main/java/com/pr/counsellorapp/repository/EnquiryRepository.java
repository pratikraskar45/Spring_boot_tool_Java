package com.pr.counsellorapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pr.counsellorapp.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {
	
	
	Page<Enquiry> findByCounsellorCid(Integer cid, Pageable pageable);


}
