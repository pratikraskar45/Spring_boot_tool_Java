package com.pr.counsellorapp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pr.counsellorapp.dto.EnquiryDto;
import com.pr.counsellorapp.dto.FilterDto;
import com.pr.counsellorapp.entity.Counsellor;
import com.pr.counsellorapp.entity.Enquiry;
import com.pr.counsellorapp.enums.ClassMode;
import com.pr.counsellorapp.enums.Course;
import com.pr.counsellorapp.enums.Status;
import com.pr.counsellorapp.exceptions.CounsellorNotFoundException;
import com.pr.counsellorapp.exceptions.EnquiryNotFoundException;
import com.pr.counsellorapp.repository.CounsellorRepository;
import com.pr.counsellorapp.repository.EnquiryRepository;

@Service
public class EnquiryService {
	@Autowired
	private EnquiryRepository enquiryRepository;
	@Autowired
	private CounsellorRepository counsellorRepository;
	
	
//===========================================================================================================================================================
	//add the enquiry 
	public ResponseEntity<String> addEnquiry(Integer cid, EnquiryDto enquiryDto) {
		Counsellor counsellor=counsellorRepository.findById(cid).orElseThrow(()-> new CounsellorNotFoundException("counsellor is not registered"));
		if (counsellor.getStatus().equals(Status.ACTIVE)) {
			//then save the enquiry
			Enquiry enquiry=new Enquiry();
			BeanUtils.copyProperties(enquiryDto, enquiry);
			enquiry.setCounsellor(counsellor);
			enquiryRepository.save(enquiry);
			return new ResponseEntity<String>("Enquiry is added Successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Inactive counsellor cannot add enquiry", HttpStatus.UNAUTHORIZED);
		}
	}
//===========================================================================================================================================================

//to Update the ClassMode
	public ResponseEntity<String> updateClassMode(Integer eid, ClassMode classMode) {
		Enquiry enquiry =enquiryRepository.findById(eid)
		.orElseThrow(()-> new EnquiryNotFoundException("Enquiry is not found") );
		enquiry.setClassMode(classMode);
		enquiryRepository.save(enquiry);
		return new ResponseEntity<>("ClassMode updated to : " + enquiry.getClassMode(), HttpStatus.OK);
	}
//===========================================================================================================================================================
//to update the Course

	public ResponseEntity<String> updateCourse(Integer eid, Course course) {
		Enquiry enquiry =enquiryRepository.findById(eid)
				.orElseThrow(()-> new EnquiryNotFoundException("Enquiry is not found") );
		enquiry.setCourse(course);
		enquiryRepository.save(enquiry);
		
		return new ResponseEntity<String>("Course Updated to : "+enquiry.getCourse(), HttpStatus.OK);
	}
//===========================================================================================================================================================
// to delete enquiry

	public ResponseEntity<String> deleteEnquiry(Integer eid) {
		Enquiry enquiry =enquiryRepository.findById(eid)
		.orElseThrow(()-> new EnquiryNotFoundException("Enquiry is not found"));
		enquiryRepository.delete(enquiry);
		return new ResponseEntity<String>("Enquiry Deleted Successfully", HttpStatus.OK);
	}
	
//===========================================================================================================================================================

	//get all enquires
	public ResponseEntity<List<Enquiry>> getAll(Integer pageNumber) {
		List<Enquiry>enquiries=enquiryRepository.findAll(PageRequest.of(pageNumber-1, 10)).toList();
		return new ResponseEntity<List<Enquiry>>(enquiries, HttpStatus.OK);
	}
//===========================================================================================================================================================
	// filter enq based on Course , Class Mode

	public ResponseEntity<List<Enquiry>> filterData(FilterDto filter) {
		Enquiry enquiry=new Enquiry();
		BeanUtils.copyProperties(filter, enquiry);
		List<Enquiry>filterList=enquiryRepository.findAll(Example.of(enquiry));
		
		return new ResponseEntity<List<Enquiry>>(filterList, HttpStatus.OK);
	}

	
//===========================================================================================================================================================


	
	
	
}
