package com.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jsp.entity.Employee;
import com.jsp.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext app=SpringApplication.run(Application.class, args);
		//to save the data into db
		EmployeeService service=app.getBean(EmployeeService.class);
		Employee emp=new Employee("Siddhi","siddhi@gmail.com",60000d);
		//to update the data
//		emp.setEid(3);
		 Employee savedEmployee=service.saveEMP(emp);
		 System.out.println("Employee is saved");
		 System.out.println(savedEmployee);
		
	}

}
