package com.jsp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_data")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_ID")
	private Integer eid;
	@Column(name = "Employee_Name")
	private String  name;
	@Column(name = "Employee_Email")
	private String email;
	@Column(name = "Employee_Salary")
	private double salary;
	@CreationTimestamp
	@Column(name = "Employee_CreateData_DateTime",nullable = false)
	private LocalDateTime createDateTime; 
	@UpdateTimestamp
	@Column(name = "Employee_UpdateData_DateTime",updatable = false,nullable = false)
	private LocalDateTime updateDateTime;
	
	
	
	public Employee() {
	}

	public Employee(String name, String email, Double salary) {
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", email=" + email + ", salary=" + salary
				+ ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime + "]";
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	 

}
