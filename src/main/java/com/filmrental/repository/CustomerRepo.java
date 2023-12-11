package com.filmrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.filmrental.entity.Customer;
import com.filmrental.model.CustomerModel;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByFirstName(String firstName);
	
	Customer findByEmail(String email);
	
	List<Customer> findByAddress_City_CityName(String cityName);
	
	List<Customer> findByAddress_City_Country_CountryName(String countryName);
	
	Customer findByAddress_Phone(String phone);
	
	List<Customer> findByActive(String active);
	
	//List<Customer> findByInActive(String active);
	
//	Customer updateFirstNameByCustomerId(int customerId, CustomerModel newFirstName);
	
//	@Modifying
//	@Query("UPDATE Customer c SET c.firstName = :newFirstName WHERE c.customerId = :customerId")
//	void updateFirstNameByCustomerId(@Param("customerId") int customerId, @Param("newFirstName") String newFirstName);


	

}
