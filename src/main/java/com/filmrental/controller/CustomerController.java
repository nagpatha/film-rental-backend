package com.filmrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.AddressModel;
import com.filmrental.model.CustomerModel;
import com.filmrental.model.StoreModel;
import com.filmrental.service.CustomerService;

@RestController
@Validated
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/post")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerModel newCustomerModel) {
		String response = customerService.addCustomer(newCustomerModel);
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/lastname/{ln}")
	public ResponseEntity<List<CustomerModel>> findByLastName(@PathVariable String ln){
		List<CustomerModel> response= customerService.findByLastName(ln);
		return new ResponseEntity<List<CustomerModel>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/firstname/{fn}")
	public ResponseEntity<List<CustomerModel>> findByFirstName(@PathVariable String fn){
		List<CustomerModel> response= customerService.findByFirstName(fn);
		 return new ResponseEntity<List<CustomerModel>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<CustomerModel> findByEmail(@PathVariable String email) {
		CustomerModel response= customerService.findByEmail(email);
		return new ResponseEntity<CustomerModel>(response,HttpStatus.OK);
	}
	
	@GetMapping("city/{city}")
	public ResponseEntity<List<CustomerModel>> findByAddress_City_CityName(@PathVariable String city){
		List<CustomerModel> response= customerService.findByAddress_City_CityName(city);
		return new ResponseEntity<List<CustomerModel>>(response,HttpStatus.OK);
	}
	
	@GetMapping("country/{country}")
	public ResponseEntity<List<CustomerModel>> findByAddress_City_Country_CountryName(@PathVariable String country){
		List<CustomerModel> response= customerService.findByAddress_City_Country_CountryName(country);
		return new ResponseEntity<List<CustomerModel>>(response, HttpStatus.OK);
	}
	
	@GetMapping("phone/{phone}")
	public ResponseEntity<CustomerModel> findByAddress_Phone(@PathVariable String phone) {
		CustomerModel response= customerService.findByAddress_Phone(phone);
		return new ResponseEntity<CustomerModel>(response,HttpStatus.OK);
	}
	
	@PutMapping("update/fn/{id}")
	public ResponseEntity<CustomerModel> updateFirstNameByCustomerId(@PathVariable int id, @RequestBody CustomerModel fn) {
		CustomerModel response= customerService.updateFirstNameByCustomerId(id, fn);
		return new ResponseEntity<CustomerModel>(response, HttpStatus.OK);
	}
	
	@PutMapping("update/ln/{id}")
	public ResponseEntity<CustomerModel> updateLastNameByCustomerId(@PathVariable int id, @RequestBody CustomerModel ln) {
		CustomerModel response= customerService.updateLastNameByCustomerId(id, ln);
		return new ResponseEntity<CustomerModel>(response,HttpStatus.OK);
	}
	
	@PutMapping("update/email/{id}")
	public ResponseEntity<CustomerModel> updateEmailOfCustomerByCustomerId(@PathVariable int id, @RequestBody CustomerModel email) {
	    CustomerModel response= customerService.updateEmailOfCustomerByCustomerId(id, email);
	    return new ResponseEntity<CustomerModel>(response,HttpStatus.OK);
	}
	
	@PutMapping("update/phone/{id}")
	public ResponseEntity<CustomerModel> updatePhoneNumberOfCustomerByCustomerId(@PathVariable int id, @RequestBody CustomerModel phone) {
		CustomerModel response= customerService.updatePhoneNumberOfCustomerByCustomerId(id, phone);
		return new ResponseEntity<CustomerModel>(response, HttpStatus.OK);
	}
	
	@GetMapping("active")
	public ResponseEntity<List<CustomerModel>> findByActive(){
		List<CustomerModel> response= customerService.findByActive();
		return new ResponseEntity<List<CustomerModel>>(response,HttpStatus.OK);
	}
	
	@GetMapping("Inactive")
	public ResponseEntity<List<CustomerModel>> findByInActive(){
		List<CustomerModel> response= customerService.findByInActive();
		return new ResponseEntity<List<CustomerModel>>(response,HttpStatus.OK);
	}
	
	@PutMapping("{id}/address")
	public ResponseEntity<CustomerModel> assignAddressToCustomer(@PathVariable int id,@RequestBody AddressModel address) {
		CustomerModel response= customerService.assignAddressToCustomer(id, address);
		return new ResponseEntity<CustomerModel>(response,HttpStatus.OK);
	}
	@PutMapping("update/store/{id}")
	public ResponseEntity<CustomerModel> assignStoreToCustomer(@PathVariable int id, @RequestBody StoreModel store) {
		CustomerModel response= customerService.assignStoreToCustomer(id, store);
		return new ResponseEntity<CustomerModel>(response,HttpStatus.OK);
	}

}
