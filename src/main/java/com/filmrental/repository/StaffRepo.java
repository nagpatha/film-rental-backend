package com.filmrental.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.filmrental.entity.Staff;
import com.filmrental.model.StaffModel;
 
public interface StaffRepo extends JpaRepository<Staff, Integer>{
	
	List<Staff> findByLastName (String lastName);
	
	List<Staff> findByfirstName (String firstName);
	
	Staff findByEmail (String email);
	
	List<Staff> findByAddress_City_CityName(String cityName);
	
	List<Staff> findByAddress_City_Country_CountryName(String countryName);
	
	Staff findByAddress_Phone(String phone);
		
}