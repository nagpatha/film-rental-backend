package com.filmrental.service;
import java.util.List;
import java.util.Map;

import com.filmrental.entity.Inventory;
import com.filmrental.model.InventoryFilmCount;
import com.filmrental.model.InventoryModel;
import com.filmrental.model.InventoryStoreCountModel;

public interface InventoryService {
	
	 public String addInventory(InventoryModel newInventory);
	 public List<Map<String, Object>> getFilmInventoryByStore(int storeId);
	 public List<Map<String, Object>> getInventoryCountByFilmId(int filmId);
	 public List<Map<String, Object>> getInventoryCountByFilmIdAndStoreId(int filmId, int storeId);
	 public List<Map<String, Object>> getInventoryCountForAllFilms();


}
