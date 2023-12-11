package com.filmrental.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.AddressModel;
import com.filmrental.model.StaffModel;
import com.filmrental.model.StoreModel;
import com.filmrental.service.StaffService;
 
@RestController
@RequestMapping("/api/staff")
public class StaffController {
	 
		@Autowired
		private StaffService staffService;
		
		@PostMapping("/post")
	    public String addNewStaff(@RequestBody StaffModel staffModel) {
	        return staffService.addNewStaff(staffModel);
	    }
		
		@GetMapping("lastname/{ln}")
		public List<StaffModel> findByLastName(@PathVariable String ln){
			return staffService.findByLastName(ln);
		}
		
		@GetMapping("firstname/{fn}")
		public List<StaffModel> findByFirstName(@PathVariable String fn){
			return staffService.findByFirstName(fn);
		}
		
		@GetMapping("/email/{email}")
		public StaffModel findByEmail(@PathVariable String email){
			return staffService.findByEmail(email);
		}
		
		@GetMapping("city/{city}")
		public List<StaffModel> findByAddress_City_CityName(@PathVariable String city){
			return staffService.findByAddress_City_CityName(city);
		}
		
		@GetMapping("country/{country}")
		public List<StaffModel> findByAddress_City_Country_CountryName(@PathVariable String country){
			return staffService.findByAddress_City_Country_CountryName(country);
		}
		
		@GetMapping("phone/{phone}")
		public StaffModel findByAddress_Phone(@PathVariable String phone){
			return staffService.findByAddress_Phone(phone);
		}
		
		@PutMapping("update/fn/{id}")
		public StaffModel updateFirstNameByStaffId(@PathVariable int id, @RequestBody StaffModel fn) {
			return staffService.updateFirstNameByStaffId(id,fn);
		}
		
		@PutMapping("update/ln/{id}")
		public StaffModel updateLastNameByStaffId(@PathVariable int id, @RequestBody StaffModel fn) {
			return staffService.updateLastNameByStaffId(id,fn);
		}
		
		@PutMapping("update/email/{id}")
		public StaffModel updateEmailByStaffId(@PathVariable int id, @RequestBody StaffModel email) {
			return staffService.updateEmailByStaffId(id,email);
		}
		
		@PutMapping("update/phone/{id}")
		public StaffModel updatePhoneNumberOfStaffByStaffId(@PathVariable int id, @RequestBody StaffModel phone) {
			return staffService.updatePhoneNumberOfStaffByStaffId(id, phone);
		}
		
		@PutMapping("{id}/address")
		public StaffModel assignAddressToStaff(@PathVariable int id, @RequestBody AddressModel address) {
			return staffService.assignAddressToStaff(id, address);
		}
		
		@PutMapping("{id}/store")
		public StaffModel assignStoreToStaff(@PathVariable int id, @RequestBody StoreModel store) {
			return staffService.assignStoreToStaff(id, store);
		}
		
		
		
}
