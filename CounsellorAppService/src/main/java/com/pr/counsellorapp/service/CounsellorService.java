package com.pr.counsellorapp.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.pr.counsellorapp.dto.CounsellorDto;
import com.pr.counsellorapp.dto.LoginDTO;
import com.pr.counsellorapp.entity.Counsellor;
import com.pr.counsellorapp.entity.Enquiry;
import com.pr.counsellorapp.enums.Status;
import com.pr.counsellorapp.exceptions.CounsellorNotFoundException;
import com.pr.counsellorapp.repository.CounsellorRepository;
import com.pr.counsellorapp.repository.EnquiryRepository;

@Service
public class CounsellorService {

	@Autowired
	private CounsellorRepository counsellorRepository;
	@Autowired
	private EnquiryRepository enquiryRepository;
	
	
//	==========================================================================================================================================
	//1-Register logic
	public ResponseEntity<String> register(CounsellorDto counsellorDto) {
		 Optional<Counsellor>opt=counsellorRepository.findByEmail(counsellorDto.getEmail());
		 
		 if (opt.isPresent()) {
			 //its already register with this email
			 return new ResponseEntity<String>("Counsellor with email:"+counsellorDto.getEmail()+" is already registerd",HttpStatus.OK);
			
		} else {
			//new registerd now
			Counsellor counsellor=new Counsellor();
			BeanUtils.copyProperties(counsellorDto, counsellor);
			counsellorRepository.save(counsellor);
			
			return new ResponseEntity<String>("Counseller with email:"+counsellorDto.getEmail()+" is register succesfully",HttpStatus.CREATED);

		}
		
		
	}
//	==========================================================================================================================================
	//2-Login Logic
	public ResponseEntity<String> login(LoginDTO loginDTO) {
		Counsellor counsellor=counsellorRepository.findByEmail(loginDTO.getEmail())
		.orElseThrow(()-> new CounsellorNotFoundException("counsellor is not registerd") );
		if (counsellor.getPassword().equals(loginDTO.getPassword())) {
			//if pass match then login
			return new ResponseEntity<>("loggedin Successfully", HttpStatus.OK);
			
		} else {
			//invalid password:
			return new ResponseEntity<>("Invalid Password",HttpStatus.BAD_REQUEST);

		}
		
	}
//	==========================================================================================================================================
//3-	update the status
	public ResponseEntity<String> updateStatus(Integer id, Status status) {
		Counsellor counsellor = counsellorRepository.findById(id)
				.orElseThrow(() -> new CounsellorNotFoundException("Counsellor is not found"));
		counsellor.setStatus(status);
		counsellorRepository.save(counsellor);
		return new ResponseEntity<String>("status updated to : " + counsellor.getStatus(), HttpStatus.OK);
	}	
//	==========================================================================================================================================
//4-get counsellor by id
	public ResponseEntity<Counsellor> getProfile(Integer id) {
		Counsellor counsellor = counsellorRepository.findById(id)
				.orElseThrow(() -> new CounsellorNotFoundException("Counsellor is not found"));
		return new ResponseEntity<>(counsellor, HttpStatus.OK);
	}
	
//	==========================================================================================================================================
//4-delete the counsellor by id
	public ResponseEntity<String> deleteProfile(Integer id) {
		Counsellor counsellor=counsellorRepository.findById(id).orElseThrow(() -> new CounsellorNotFoundException("Counsellor is not found"));
		counsellorRepository.delete(counsellor);
		return new ResponseEntity<>("Counsellor deleted successfully", HttpStatus.OK);
	}
	
//	==========================================================================================================================================

	

	
	//	==========================================================================================================================================
	//5-get enquiry by cid
	public ResponseEntity<List<Enquiry>> getEnqByCid(Integer id, Integer pageNumber) {
	    // Check if the counsellor exists
	    counsellorRepository.findById(id)
	        .orElseThrow(() -> new CounsellorNotFoundException("Counsellor is not found"));

	    // Get paginated enquiries
	    Page<Enquiry> enquiryPage = enquiryRepository.findByCounsellorCid(id, PageRequest.of(pageNumber - 1, 2));
	    List<Enquiry> enquiries = enquiryPage.getContent();

	    return new ResponseEntity<>(enquiries, HttpStatus.OK);
	}
	
	//without pagination
//	public ResponseEntity<List<Enquiry>> getEnqByCid(Integer id) {
//	counsellorRepository.findById(id).orElseThrow(()-> new CounsellorNotFoundException("Counsellor is not found"));
//	List<Enquiry> enquiries=counsellor.getEnquiries();
//	return new ResponseEntity<List<Enquiry>>(enquiries, HttpStatus.OK);
//}

	
	
}




