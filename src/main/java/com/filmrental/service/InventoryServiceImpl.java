package com.filmrental.service;

import java.util.stream.Collectors;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.entity.Film;
import com.filmrental.entity.Inventory;
import com.filmrental.entity.Store;
import com.filmrental.model.InventoryFilmCount;
import com.filmrental.model.InventoryModel;
import com.filmrental.model.InventoryStoreCountModel;
import com.filmrental.repository.FilmRepo;
import com.filmrental.repository.InventoryRepo;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepo iRepo;

	@Override
	public String addInventory(InventoryModel newInventory) {
		Inventory inventory = new Inventory();
		BeanUtils.copyProperties(newInventory, inventory);
		{
			Film film = new Film();
			BeanUtils.copyProperties(newInventory.getFilm(), film);
			inventory.setFilm(film);
		}
		{
			Store store = new Store();
			BeanUtils.copyProperties(newInventory.getStore(), store);
			inventory.setStore(store);
		}
		
		iRepo.save(inventory);
		
		return "Record Added SuccessFully";
	}
	
	
	public List<Map<String, Object>> getFilmInventoryByStore(int storeId) {
        List<Object[]> filmInventoryList = iRepo.getFilmInventoryByStoreId(storeId);

        return filmInventoryList.stream()
                .map(objArray -> {
                    Map<String, Object> filmInventoryMap = Map.of(
                            "title", (String) objArray[0],
                            "copies", ((Number) objArray[1]).intValue()
                    );
                    return filmInventoryMap;
                })
                .collect(Collectors.toList());
    }
	
	public List<Map<String, Object>> getInventoryCountByFilmId(int filmId) {
        List<Object[]> result = iRepo.getInventoryCountByFilmId(filmId);

        return result.stream()
                .map(row -> { Map<String, Object> map = Map.of(
                            "storeAddress", row[0],
                            "numberOfCopies", row[1]
                    );
                    return map;
                })
                .collect(Collectors.toList());
    }


	@Override
	public List<Map<String, Object>> getInventoryCountByFilmIdAndStoreId(int filmId, int storeId) {
		 List<Object[]> result = iRepo.getInventoryCountByFilmIdAndStoreId(filmId, storeId);

	        // Transform the result into a list of maps
	        return result.stream()
	                .map(row -> {
	                    Map<String, Object> map = new HashMap<>();
	                    map.put("storeAddress", ((Store)row[0]).getStoreId());  // Assuming Store has a getStoreAddress() method
	                    map.put("numberOfCopies", row[1]);
	                    return map;
	                })
	                .collect(Collectors.toList());

	}

    @Override
    public List<Map<String, Object>> getInventoryCountForAllFilms() {
        return iRepo.getInventoryCountForAllFilms();
    }


}





	


