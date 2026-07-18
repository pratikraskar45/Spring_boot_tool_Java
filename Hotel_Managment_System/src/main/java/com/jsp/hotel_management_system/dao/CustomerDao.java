package com.jsp.hotel_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotel_management_system.dto.Customer;
import com.jsp.hotel_management_system.repo.CustomerRepo;
@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepo customerRepo;
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	public Customer deleteCustomer(Customer customer) {
		 customerRepo.delete(customer);
		 return customer;
		
	}
	
	public Customer getCustomerbyid(int customer_id) {
		if (customerRepo.findById(customer_id).isPresent()) {
			return customerRepo.findById(customer_id).get();
		}else {
			return null;
		}
	}
	public List<Customer> getallCustomers() {
		return customerRepo.findAll();
		
	}
	public Customer getCustomerbyemail(String customer_email) {
		if (customerRepo.getCustomerbyemail(customer_email)!=null) {
			return customerRepo.getCustomerbyemail(customer_email);
			
		} else {
			return null;
		}
		
	}

}
