package com.filmrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.Store;

public interface StoreRepo extends JpaRepository<Store, Integer>{

}
