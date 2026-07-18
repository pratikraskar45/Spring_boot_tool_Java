package com.pr.counsellorapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pr.counsellorapp.dto.EnquiryDto;
import com.pr.counsellorapp.dto.FilterDto;
import com.pr.counsellorapp.entity.Enquiry;
import com.pr.counsellorapp.enums.ClassMode;
import com.pr.counsellorapp.enums.Course;
import com.pr.counsellorapp.service.EnquiryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/enq")
public class EnquiryController {
	@Autowired
	private EnquiryService enquiryService;
	
//===========================================================================================================================================================

	//add the enquiry
	@PostMapping("/add/{cid}")
	public ResponseEntity<String> addEnquiry(@PathVariable Integer cid,@RequestBody EnquiryDto enquirydetDto) {
		
		return enquiryService.addEnquiry(cid,enquirydetDto);
	}
	//postman-POST-http://localhost:3000/enq/add/1
		//raw-json-
//		{
//		    "name":"Pratik",
//		    "phone":7565895698,
//		    "email":"pratik@gmail.com",
//		    "course":"DATA_SCIENTIST",
//		    "fees":50000
//		}
//===========================================================================================================================================================

	// updating enq Class Mode
	
	@PutMapping("/update_ClassMode/{eid}")
	public ResponseEntity<String> updateClassMode(@PathVariable Integer eid,@RequestParam ClassMode classMode) {
		return enquiryService.updateClassMode(eid,classMode);
	}
	//POSTMAN-Put-http://localhost:3000/enq/update_ClassMode/9?classMode=ONLINE
	
//===========================================================================================================================================================

	// update enq Course
	@PutMapping("/update_Course/{eid}")
	public ResponseEntity<String> updateCourse(@PathVariable Integer eid, @RequestParam Course course) {
		return enquiryService.updateCourse(eid,course);
	}
	//POSTMAN-PUT-http://localhost:3000/enq/update_Course/8?course=TESTING
//===========================================================================================================================================================
	//  Delete Enquiry
	@DeleteMapping("/delete/{eid}")
	public ResponseEntity<String> deleteEnquiry(@PathVariable Integer eid) {
		return enquiryService.deleteEnquiry(eid);
	}
	//POSTMAN-DELETE-http://localhost:3000/enq/delete/11
//===========================================================================================================================================================

	// get all(pagination)
		@GetMapping("/enqs/{pageNumber}")
		public ResponseEntity<List<Enquiry>> getAll(@PathVariable Integer pageNumber) {
			return enquiryService.getAll(pageNumber);
		}
		//POSTMAN-GET-http://localhost:3000/enq/enqs/1(1 is page number)
//===========================================================================================================================================================

	// filter enq based on Course , Class Mode
	@GetMapping("/filter")
	public ResponseEntity<List<Enquiry>> filterData(@RequestBody FilterDto filter) {
		return enquiryService.filterData(filter);
	}
	//POSTMAN-GET-http://localhost:3000/enq/filter
	//BODY-RAW-JSON-
//	{
//    "classMode":"ONLINE",
//    "course":"TESTING"
//    	}
//===========================================================================================================================================================

	

}
