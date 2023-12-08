package com.filmrental.service;

import java.util.List;

import com.filmrental.entity.Customer;
import com.filmrental.model.CustomerModel;

public interface CustomerService {
	
	List<CustomerModel> findByLastName(String lastName);
	
	List<CustomerModel> findByFirstName(String firstName);
	
	CustomerModel findByEmail(String email);

}
