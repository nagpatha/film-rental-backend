package com.filmrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.CustomerModel;
import com.filmrental.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/lastname/{ln}")
	public List<CustomerModel> findByLastName(@PathVariable String ln){
		return customerService.findByLastName(ln);
	}
	
	@GetMapping("/firstname/{fn}")
	public List<CustomerModel> findByFirstName(@PathVariable String firstName){
		return customerService.findByFirstName(firstName);
	}
	
	@GetMapping("/email/{email}")
	public CustomerModel findByEmail(@PathVariable String email) {
		return customerService.findByEmail(email);
	}
	
}
