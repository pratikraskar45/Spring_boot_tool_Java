package com.pr.counsellorapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pr.counsellorapp.dto.CounsellorDto;
import com.pr.counsellorapp.dto.LoginDTO;
import com.pr.counsellorapp.entity.Counsellor;
import com.pr.counsellorapp.entity.Enquiry;
import com.pr.counsellorapp.enums.Status;
import com.pr.counsellorapp.service.CounsellorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/couns")
@CrossOrigin("http://localhost:5173/")//url of react frontend(view)
public class CounsellorController {
	@Autowired
	private CounsellorService counsellorService;
	
	
//==========================================================================================================================================

	@PostMapping("/register")
	public ResponseEntity<String> registerCounsoller(@RequestBody CounsellorDto counsellorDto) {
		
		return counsellorService.register(counsellorDto);	
	}
	//Postman-Post-url-http://localhost:3000/couns/register
			//body-raw-JSON-
			//{
			//
			//"name":"Jeevan",
			//"phone":8888888888,
			//"email":"jeevan@gmail.com",
			//"password":"jeevan@123"
			//}
//==========================================================================================================================================

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO ) {
		return counsellorService.login(loginDTO);
	}
	//Postman-Get-url-http://localhost:3000/couns/login
		//body-raw-JSON-
		//{
		//"email":"jeevan@gmail.com",
		//"password":"jeevan@123"
		//}
//==========================================================================================================================================
	//update the status of counselor
	@PutMapping("update/{id}")
	public ResponseEntity<String> updateStatus(@PathVariable Integer id, @RequestParam Status status ) {
		
		return counsellorService.updateStatus(id,status);
		
	}
	//Postman-Put-http://localhost:3000/couns/update/1?status=INACTIVE
//==========================================================================================================================================

	//get counsellor by id
	@GetMapping("/profile/{id}")
	public ResponseEntity<Counsellor> getProfile(@PathVariable Integer id) {
		return counsellorService.getProfile(id);
	}
	//postman-Get-http://localhost:3000/couns/profile/1
//==========================================================================================================================================

	//delete by id
	@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteProfile(@PathVariable Integer id) {
		return counsellorService.deleteProfile(id);
		
	}
	//Postman-Get-http://localhost:3000/couns/delete/2
//==========================================================================================================================================
	// get all the enquiries by cid, use pagination
		@GetMapping("/enqs/{id}")
		public ResponseEntity<List<Enquiry>> getEnqByCid(@PathVariable Integer id,@RequestParam Integer pageNumber) {
			return counsellorService.getEnqByCid(id, pageNumber);
		}
		//postman-GET-http://localhost:3000/couns/enqs/1?pageNumber=1
//==========================================================================================================================================



		
	

}
