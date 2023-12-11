package com.filmrental.service;

import java.util.List;

import com.filmrental.model.AddressModel;
import com.filmrental.model.StaffModel;
import com.filmrental.model.StoreModel;

public interface StaffService {
	
	String addNewStaff(StaffModel staffModel);
	
	List<StaffModel> findByLastName (String lastName);
	
	List<StaffModel> findByFirstName (String firstName);
	
	StaffModel findByEmail (String email);
	
	List<StaffModel> findByAddress_City_CityName(String cityName);
	
	List<StaffModel> findByAddress_City_Country_CountryName(String countryName);

	StaffModel findByAddress_Phone(String phone);

	StaffModel updateFirstNameByStaffId(int staffid, StaffModel newFirstName);
	
	StaffModel updateLastNameByStaffId(int staffid, StaffModel newLastName);

	StaffModel updateEmailByStaffId(int staffId, StaffModel newEmail);

	StaffModel updatePhoneNumberOfStaffByStaffId(int staffId, StaffModel newPhoneNumber);

	StaffModel assignAddressToStaff(int staffId, AddressModel address);

	StaffModel assignStoreToStaff(int staffId, StoreModel storeModel);

	
	
	
 
}