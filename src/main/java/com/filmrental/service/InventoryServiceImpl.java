package com.filmrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.repository.InventoryRepo;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryRepo inventoryRepo;
}
