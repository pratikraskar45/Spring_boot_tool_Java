package com.jsp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class TestController {
	@GetMapping("/get")
	public String textmsg() {
		return  "Used for Fecth";
	}
	@PostMapping("/post")
	public String postMethodName() {
		return "Used for saving";
	}
	@PutMapping("/put")
	public String putMethodName() {	
		return "Used for Update Multiple Data";
	}
	@PatchMapping("/patch")
	public String patchMethodName() {		
		return "Used for Update a single data";
	}
	@DeleteMapping("/delete")
	public String deleteMethodName() {		
		return "Used for delete";
	}
	
	
	
	

}
