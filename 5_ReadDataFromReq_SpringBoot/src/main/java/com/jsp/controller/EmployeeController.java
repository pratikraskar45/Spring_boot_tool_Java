package com.jsp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
	//postman
	//1-http://localhost:8080/emp?eid=101&name=Pratik
	
	@GetMapping
	//@RequestParam(name="id") Integer eid// whenever change the name of key 
	public String getInfo(@RequestParam Integer eid,@RequestParam String name) {
		System.out.println("got the getinfo request");
		System.out.println(eid);
		System.out.println(name);
		return "Eid: "+eid + ",Ename: "+name;
	}
	//postman-data from url path
	//http://localhost:8080/emp/101/Pratik
	@PostMapping("/{eid}/{name}")
	public String getData(@PathVariable Integer eid,@PathVariable String name) {
		System.out.println("Read");
		System.out.println(eid);
		System.out.println(name);
		return "Eid: "+eid+",Ename: "+name;
	}
	//postman-headers-token-shjhsjhfsh
	//http://localhost:8080/emp
	@PutMapping
	public String get(@RequestHeader String token) {
		System.out.println("got req");
		System.out.println(token);
		return "Token:"+token;
	}
	//postman-the read the data from body-raw-json//http://localhost:8080/emp/save
	//{"eid":101,"name":"Pratik","salary":45000,"ispresnt":true}
	@PostMapping("/save")
	public Employee getbodyData(@RequestBody Employee employee) {
		System.out.println("api trigger");
		System.out.println(employee);
		return employee;
	}
	//add dependencies Jackson Dataformat XML
	//postman-we are store in xml-body-raw-xml format SB //http://localhost:8080/emp/xml
	//body-raw-xml<Employee><eid>101</eid><name>Pratikkkkk</name><salary>45000</salary><ispresnt>true</ispresnt></Employee>
	@PostMapping(value = "/xml",produces = "application/xml",consumes = "application/xml")
	public Employee getbodyDatafromxml(@RequestBody Employee employee) {
		System.out.println("api trigger");
		System.out.println(employee);
		return employee;
	}
	
	
	//postman-store and get data in xml and json both format //http://localhost:8080/emp/xml/json
	//headers accpet:application/xml  content type:application/json

	//body-raw-xml<Employee><eid>101</eid><name>Pratikkkkk</name><salary>45000</salary><ispresnt>true</ispresnt></Employee>
	//{"eid":101,"name":"Pratik","salary":45000,"ispresnt":true}
	@PostMapping(value = "/xml/json",produces = {"application/xml",
			                                     "application/json",}, 
	                                   consumes = { "application/xml",
	                                		         "application/json",})
	public Employee getbodyDatafromxmlorjson(@RequestBody Employee employee) {
		System.out.println("api trigger");
		System.out.println(employee);
		return employee;
	}
	
	
	
	
	
	
	
	
   //response entity for change the stutus code 
	//postman-http://localhost:8080/emp/changestuatus   {"eid":101,"name":"Pratik","salary":45000,"ispresnt":true}
	//postman op-201-created
	@PostMapping(value = "/changestuatus",produces = {"application/xml",
            "application/json",}, 
  consumes = { "application/xml",
		         "application/json",})
	//ResponseEntity<String>
public ResponseEntity<Employee> getbodyDatafromxmlorjson1(@RequestBody Employee employee) {
System.out.println("api trigger");
System.out.println(employee);
ResponseEntity<Employee>re=new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
//using a string give the msg
//ResponseEntity<String>re=new ResponseEntity<String>("Succesfully Saved ",HttpStatus.CREATED);

return re;
}

	
	
	
	
	
	
	//Change the status code in string ,int,object and any type using ResponseEntity<?>
//	postman-http://localhost:8080/emp/changeboth?id=101 //op-get all data
	//op-404 not found //Employee with id 105 is not present 
	@GetMapping("/changeboth")
	public ResponseEntity<?> getInfo1(@RequestParam(name = "id") Integer eid) {
		System.out.println("got the getinfo request");
		// TODO : produce response with status code 200 OK with employee details
		if (eid==101) {
			Employee employee=new Employee();
			employee.setEid(eid);
			employee.setName("Pratik");
			employee.setIspresnt(false);
			employee.setSalary(45000);
			
			return ResponseEntity.ok(employee);
		} else {
			// TODO : produces response with status code 404 Not Found with some message
			return new ResponseEntity<String>("Employee with id " + eid + " is not present ", HttpStatus.NOT_FOUND);

		}
	}

	
	
	//for handel the exception 
	//postman-http://localhost:8080/emp/exc
	
	@GetMapping("/exc")
	public String handelException() {
		
//		int a=10/0; //its arithmetic exception
		
		
//		String string=null;
//		string.charAt(0);//cannot invoke methods with null
		
		int b[]=new int[2];
		System.out.println(b[5]);//ArrayIndexOutOfBoundsException
		
		return "How are exception";
	}
	

}
