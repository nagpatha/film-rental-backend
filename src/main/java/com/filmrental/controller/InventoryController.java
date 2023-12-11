package com.filmrental.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.InventoryModel;
import com.filmrental.service.InventoryService;
import com.filmrental.service.InventoryServiceImpl;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	@Autowired
	private InventoryServiceImpl inventoryService;
	
	@PostMapping("/add")
	public String addInventory(@RequestBody InventoryModel newInventory) {
		return inventoryService.addInventory(newInventory);
	}
	
	@GetMapping("/storeId/{storeId}")
	public List<Map<String, Object>> getFilmInventoryByStore(@PathVariable("storeId") int storeId){
		return inventoryService.getFilmInventoryByStore(storeId); 
	}
	
	
	@GetMapping("/film/{filmId}")
	public List<Map<String, Object>> getInventoryCountByFilmId(@PathVariable("filmId") int filmId){
		return inventoryService.getInventoryCountByFilmId(filmId);
	}
	
	@GetMapping("/film/{filmId}/store/{storeId}")
	public List<Map<String, Object>> getInventoryCountByFilmIdAndStoreId(@PathVariable("filmId") int filmId,@PathVariable("storeId") int storeId){
		return inventoryService.getInventoryCountByFilmIdAndStoreId(filmId, storeId); 
	}
	
	@GetMapping("/films")
	public List<Map<String, Object>> getInventoryCountForAllFilms(){
		return inventoryService.getInventoryCountForAllFilms();
	}
}