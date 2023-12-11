package com.filmrental.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.filmrental.entity.Actor;
import com.filmrental.entity.Inventory;
import com.filmrental.model.InventoryFilmCount;
import com.filmrental.model.InventoryStoreCountModel;

public interface InventoryRepo extends JpaRepository<Inventory, Integer>{
				
	@Query("SELECT f.title, COUNT(i) " +
	           "FROM Inventory i " +
	           "JOIN i.film f " +
	           "WHERE i.store.storeId = :storeId " +
	           "GROUP BY f.title")
	    List<Object[]> getFilmInventoryByStoreId(@Param("storeId") int storeId);
	    
	    @Query("SELECT s.storeId, COUNT(i) " +
	            "FROM Inventory i " +
	            "JOIN i.store s " +
	            "WHERE i.film.filmId = :filmId " +
	            "GROUP BY s.storeId")
	     List<Object[]> getInventoryCountByFilmId(@Param("filmId") int filmId);
	     
	     @Query("SELECT s, COUNT(i) " +
	             "FROM Inventory i " +
	             "JOIN i.store s " +
	             "JOIN i.film f " +
	             "WHERE f.filmId = :filmId AND s.storeId = :storeId " +
	             "GROUP BY s")
	      List<Object[]> getInventoryCountByFilmIdAndStoreId(@Param("filmId") int filmId, @Param("storeId") int storeId);

	      @Query("SELECT f.title AS title, COUNT(i) AS copyCount FROM Inventory i JOIN i.film f GROUP BY f.title")
	      List<Map<String, Object>> getInventoryCountForAllFilms();
}
