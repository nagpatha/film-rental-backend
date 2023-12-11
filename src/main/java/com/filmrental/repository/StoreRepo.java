package com.filmrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.filmrental.entity.Store;

public interface StoreRepo extends JpaRepository<Store, Integer>{ 
	
	Store findByAddress_Phone(String phone);
	
	List<Store> findByAddress_City_Country_CountryName(String countryName);
	
//	Store updatePhoneNumberOfStoreByStoreId(int storeId, StoreModel newPhoneNumber);
	
	
//	String addNewStore(StoreModel newStore);
	


}
