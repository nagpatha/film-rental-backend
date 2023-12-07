package com.filmrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByFirstName(String firstName);
	
	Customer findByEmail(String email);

}
