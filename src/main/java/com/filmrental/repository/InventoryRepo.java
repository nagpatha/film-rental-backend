package com.filmrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer>{

}
