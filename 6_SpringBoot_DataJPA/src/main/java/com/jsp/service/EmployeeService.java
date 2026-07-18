package com.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.entity.Employee;
import com.jsp.repositry.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;
	//to save record
	public Employee saveEMP(Employee employee) {
		repo.save(employee);
		return employee;
		
	}
	
}
