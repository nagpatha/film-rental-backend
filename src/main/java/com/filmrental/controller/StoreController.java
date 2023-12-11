package com.filmrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.AddressModel;
import com.filmrental.model.CustomerModel;
import com.filmrental.model.StaffModel;
import com.filmrental.model.StoreModel;
import com.filmrental.service.StoreService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/store")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("phone/{phone}")
	public ResponseEntity<StoreModel> findByAddress_Phone(@PathVariable String phone) {
		StoreModel response =  storeService.findByAddress_Phone(phone);
		return new ResponseEntity<StoreModel>(response, HttpStatus.OK);
	}
	
	@GetMapping("country/{country}")
	public ResponseEntity<List<StoreModel>> findByAddress_City_Country_CountryName(@PathVariable String country){
		List<StoreModel> response = storeService.findByAddress_City_Country_CountryName(country);
		return new ResponseEntity<List<StoreModel>>(response, HttpStatus.OK);
	}
	
	@PostMapping("post")
	public ResponseEntity<String> addNewStore(@Valid @RequestBody StoreModel newStore) {
		String response = storeService.addNewStore(newStore);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("update/phone/{id}")
	public ResponseEntity<StoreModel> updatePhoneNumberOfStoreByStoreId(@PathVariable int id, @RequestBody StoreModel phone) {
		StoreModel response =  storeService.updatePhoneNumberOfStoreByStoreId(id, phone);
		return new ResponseEntity<StoreModel>(response, HttpStatus.OK);
	} 
	
	@GetMapping("customer/{id}")
	public ResponseEntity<List<CustomerModel>> getCustomersOfStoreByStoreId(@PathVariable int id) {
		List<CustomerModel> response =  storeService.getCustomersOfStoreByStoreId(id);
		return new ResponseEntity<List<CustomerModel>>(response, HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}/address")
	public ResponseEntity<StoreModel> assignAddressToStore(@PathVariable int id, @RequestBody AddressModel address) {
		StoreModel response =  storeService.assignAddressToStore(id, address);
		return new ResponseEntity<StoreModel>(response, HttpStatus.OK);
	}
	
	@GetMapping("/staff/{id}")
	public ResponseEntity<List<StaffModel>> getStaffOfStoreByStoreId(@PathVariable int id){
		List<StaffModel> response = storeService.getStaffOfStoreByStoreId(id);
		return new ResponseEntity<List<StaffModel>>(response, HttpStatus.OK);
	}
	
//	@PutMapping("/{id}/manager")
//	public ResponseEntity<List<ManagerModel>> assignStoreToManagers(@PathVariable int id, @RequestBody ManagerModel storeModel){
//		List<ManagerModel> response = storeService.assignStoreToManager(id, storeModel);
//		return new ResponseEntity<List<ManagerModel>>(response, HttpStatus.OK);
	
//	@PutMapping
//	public StoreModel assignManagerToStore( @PathVariable int id,@RequestBody StoreModel manager) {
//		StoreModel updatedStore = storeService.assignManagerToStore(id, manager);
//        return storeService.assignManagerToStore(updatedStore);
//	
//	}
}

