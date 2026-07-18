package com.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.dto.Item;
import com.jsp.repo.ItemRepo;

@Repository
public class ItemDao {
	@Autowired
	private ItemRepo itemRepo;
	
	
	//save 
	public Item saveItem(Item item) {
		return itemRepo.save(item);
		
	}
	//update
		public Item updateitem(int id, Item item) {
			Optional<Item> item2= itemRepo.findById(id);
			
			if (item2.isPresent()) {
				item.setId(id);
				return itemRepo.save(item);
				
			}else {
				return null;
			}		
		}
		//delete
		public Item deleteItem(int id) {
			Item item= itemRepo.findById(id).get();
			itemRepo.delete(item);
			return item;
			
		}
		//get by id
		public Item getItembyid(int id) {
		return	itemRepo.findById(id).get();
			
		}
		//get all item
		public List<Item> getallItems() {
			return itemRepo.findAll();
			
		}

}
