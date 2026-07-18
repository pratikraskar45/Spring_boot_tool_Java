package com.jsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.dto.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
