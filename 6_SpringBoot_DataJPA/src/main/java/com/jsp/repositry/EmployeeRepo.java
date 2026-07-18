package com.jsp.repositry;
//lots of features is used jpaRepositery
import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
