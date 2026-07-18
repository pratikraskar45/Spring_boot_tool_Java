package com.jsp.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jsp.entiry.Product;
@RepositoryRestResource(path = "products")//its perform crud operation automatically 
public interface ProductRepo extends  JpaRepository<Product, Integer>{
	
	//get by name
	Page<Product>findByNameContaining(@Param("name")String name,Pageable pageable);
	//postman-get-url-http://localhost:8080/products/search/findByNameContaining?name=Iphone
	
	
	
	//get data by price
	Page<Product> findByPriceLessThanEqual(@Param("price") Long price,Pageable pageable);
	//postman-get-url-http://localhost:8080/products/search/findByPriceLessThanEqual?price=20000
	
	
	
	
	
	
	
	//postman
	
	//1-to save-post-http://localhost:8080/products
	//body-raw-json-
//	{
//    "description":"Black color",
//    "name":"Iphone 16",
//    "qty":9
//}
	
	//2-getall
	//get-http://localhost:8080/products
	//get the all data have in db
	
	//3-get by id
	//get-http://localhost:8080/products/1
	//get the 1 no pid data
	
	
	
	//4-delete the data
	//Delete-http://localhost:8080/products/1
	//delete the id
	
	//5-update the data
	//Put-url-http://localhost:8080/products/2
	//body-raw-JSON-
//	{
//	    "description":"12 gb silver",
//	    "name":"Samsung s24",
//	    "price":150000,
//	    "qty":10
//	}
	//6-pagination
	//postman-get-Url-http://localhost:8080/products?page=0&size=10

}
