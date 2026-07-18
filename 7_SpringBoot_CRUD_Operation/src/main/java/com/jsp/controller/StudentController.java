package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.entity.Student;
import com.jsp.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	//--------------------------------------------------------------------------
	
	//to save api 
	//postman-post-url-http://localhost:8080/save
	//raw-json{"name":"Siddhi","email":"siddhi@gmail.com","std":"14"} send
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudnet(@RequestBody Student student) {
		ResponseEntity<Student> savedstudent=studentService.saveStudent(student);
		return savedstudent;
	}
	
	
	//--------------------------------------------------------------------------

	
	//to get data by id
	// postman-get-url-http://localhost:8080/get?sid=1  param-key sid -1
	
	@GetMapping("/get")
	public ResponseEntity<Student> getstudentByID(@RequestParam Integer sid) {
		ResponseEntity<Student>responseEntity= studentService.getstudnetbyid(sid);
		
		return responseEntity ;
	}
	//--------------------------------------------------------------------------

	//to get all data inside the table
	//postman-http://localhost:8080/getall
	@GetMapping("/getall")
	public ResponseEntity<List<Student>> getallStudnet() {
		
		ResponseEntity<List<Student>>responseEntity=studentService.getallstudnet();
		return	responseEntity;
	}
	//--------------------------------------------------------------------------
	//update name if you want to change email and all add to @RequestParam pass the entity
	//postman-http://localhost:8080/update/11?name=Pogo
	@PutMapping("/update/{sid}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer sid, @RequestParam String name) {
		return studentService.updateStudentName(sid, name);
	}
	//--------------------------------------------------------------------------
// delete the student by id
	//postman- http://localhost:8080/delete?sid=10   
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudentById(@RequestParam Integer sid) {
		return studentService.deleteStudent(sid);
	}
	//--------------------------------------------------------------------------
	
	
	//pagination  means the in single page how many add the data means we have 1000 records and we show first 30 data in first page another is next page 
	//postman-http://localhost:8080/page?pageNumber=1  //we got first 3 data
	

	@GetMapping("/page")
	public ResponseEntity<List<Student>> getByPage(@RequestParam Integer pageNumber) {
		ResponseEntity<List<Student>> students = studentService.getByPage(pageNumber);
		return students;
	}
	//--------------------------------------------------------------------------
	//sorting data by ascending descending and by std
	//postman-http://localhost:8080/sort?param=std  //get data by sequences

	@GetMapping("/sort")
	public ResponseEntity<List<Student>> sortStudents(@RequestParam String param) {
		return studentService.sortStudents(param);
	}
	//--------------------------------------------------------------------------
	//filter the data by name or anything
	//postman-http://localhost:8080/filter  
	//raw-json-{"std":13}  its filter by std 

	@GetMapping("/filter")
	public ResponseEntity<List<Student>> filterRecords(@RequestBody Student student) {
		return studentService.filter(student);
	}
	//--------------------------------------------------------------------------
	
	//find the data using the std 
	//postman-http://localhost:8080/fetch?std=15       
//	its find that particular response 

	@GetMapping("/fetch")
	public ResponseEntity<List<Student>> getByStd(@RequestParam Integer std) {
		return studentService.getByStd(std);
	}
	
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------
//to validate
	@PostMapping("/validate")
	public  Student validateEntity(@RequestBody @Valid Student student) {
		return student;
	}
	
	//--------------------------------------------------------------------------


	

}
