package com.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.entity.Student;
import com.jsp.exception.StudentNotFoundException;
import com.jsp.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	//--------------------------------------------------------------------------

	//1-save data
	public ResponseEntity<Student> saveStudent(Student student) {
		Student saved= studentRepository.save(student);
		return new ResponseEntity<Student>(saved,HttpStatus.CREATED);
	}
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------

	//2-to get data by id
	
	public ResponseEntity<Student> getstudnetbyid(Integer sid) {
		Optional<Student> opt= studentRepository.findById(sid);
		//1
//		if (opt.isPresent()) {
//			//student is present
//			Student student= opt.get();
//			System.out.println(student);
//		} else {
//			//student not present sent msg 
//			System.out.println("Id not Found");
//
//		}
		//2-
		Student student = opt.orElseThrow(()-> new StudentNotFoundException("Student Not Found"));
		return new ResponseEntity<>(student,HttpStatus.OK);
		
		
	}
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------

	
	
	
	//3-get all studnet
	
	
	
	public ResponseEntity<List<Student>> getallstudnet() {
		List<Student>studentList= studentRepository.findAll();
		
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
		
		
	}
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------

	//update 
	public ResponseEntity<Student> updateStudentName(Integer sid, String name) {
		Student student = studentRepository.findById(sid)
				.orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
		student.setName(name);
		Student saved = studentRepository.save(student);
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}
	
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------

	
	//delete
	public ResponseEntity<String> deleteStudent(Integer sid) {
		Student student = studentRepository.findById(sid)
				.orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
		studentRepository.delete(student);
		return new ResponseEntity<>("Student deleted", HttpStatus.OK);
	}
	
	
	//--------------------------------------------------------------------------
	//--------------------------------------------------------------------------

	// pagination
		public ResponseEntity<List<Student>> getByPage(Integer pageNumber) {

			Pageable pageable = PageRequest.of(pageNumber - 1, 3);

			Page<Student> all = studentRepository.findAll(pageable);

			List<Student> list = all.toList();

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		}
		//--------------------------------------------------------------------------
		//--------------------------------------------------------------------------

		
		// Sorting
		public ResponseEntity<List<Student>> sortStudents(String param) {

//			List<Student> students = studentRepository.findAll(Sort.by(param).descending());
//			List<Student> students = studentRepository.findAll(Sort.by(param).ascending());
			List<Student> students = studentRepository.findAll(Sort.by(param));

			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		}
		//--------------------------------------------------------------------------
		//--------------------------------------------------------------------------

		
		// QueryByExample/filters
		public ResponseEntity<List<Student>> filter(Student student) {

			Example<Student> example = Example.of(student);

			List<Student> all = studentRepository.findAll(example);

			return new ResponseEntity<List<Student>>(all, HttpStatus.OK);
		}
		//-------------------------------------------------------------------------
		//--------------------------------------------------------------------------
//to create a custome method 
		
		public ResponseEntity<List<Student>> getByStd(Integer std) {
			
			List<Student> students = studentRepository.findByStd(std);//custom query
			
//			List<Student> students = studentRepository.getByStd(std);//custom query
			
			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		}
		
}
