package com.jsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	// custom queries
//		@Query("select s from Student s Where s.sid=?1") //indexed based parameter
		@Query("select s from Student s Where s.sid=:sid") // naming based parameter
		List<Student> getByStd(Integer sid);

		@Query("select s from Student s where s.name=?1 and s.std=?2")
		List<Student> getByName(String name, Integer std);

		// custom methods
		List<Student> findByStd(Integer std);

		List<Student> findByStdAndName(Integer std, String name);

		List<Student> findBySidOrName(Integer sid, String name);

		List<Student> findBySidAndNameAndEmail(Integer sid, String name, String email);

}
