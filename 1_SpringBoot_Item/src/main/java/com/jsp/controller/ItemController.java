package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.dao.ItemDao;
import com.jsp.dto.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemDao itemdao;
	
	
	//1-save
	@PostMapping("/saveitem")
	public Item saveItem(@RequestBody Item item) {
		System.out.println("===save item api trigger=====");
		return itemdao.saveItem(item);
		}
	
	
	//2-update
	@PutMapping("/updateitem")
	public Item updatItem(@RequestParam int id,@RequestBody Item item) {
		System.out.println("=====update item api trigger=====");
		return itemdao.updateitem(id, item);
	}
	
	
	//3-delete
	@DeleteMapping("/deleteitem")
	public Item deleItem(@RequestParam int id) {
		System.out.println("=====delete item api trigger=======");
		return itemdao.deleteItem(id);	
	}
	
	
	//4-get by id
	@GetMapping("/getitembyid")
	public Item getItembyid(@RequestParam int id) {
		System.out.println("=====get item by id api trigger=======");
		return itemdao.getItembyid(id);
	}
	
	
	//5-get all
	@GetMapping("/getallitem")
	public List<Item> getallItems() {
		System.out.println("======get all item api trigger==========");
		return itemdao.getallItems();	
	}
	
	

}
