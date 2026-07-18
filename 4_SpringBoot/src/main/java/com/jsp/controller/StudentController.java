package com.jsp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@RequestMapping("/student")
public class StudentController {
	@GetMapping("/get")
	public String getMethodName() {
		return "Used for get data";
	}
	@PostMapping("/save")
	public String postMethodName() {
		
		
		return "Used for save data";
	}
	@PutMapping("/update_multiple")
	public String putMethodName() {	
		return "Used for Update Multiple Data";
	}
	@PatchMapping("/update_one")
	public String patchMethodName() {		
		return "Used for Update a single data";
	}
	@DeleteMapping("/delete")
	public String deleteMethodName() {		
		return "Used for delete";
	}
	

}
