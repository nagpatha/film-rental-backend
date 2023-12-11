package com.filmrental.service;

import java.util.List;

import com.filmrental.entity.Customer;
import com.filmrental.model.AddressModel;
import com.filmrental.model.CustomerModel;
import com.filmrental.model.StoreModel;

public interface CustomerService {
	
	List<CustomerModel> findByLastName(String lastName);
	
	List<CustomerModel> findByFirstName(String firstName);
	
	CustomerModel findByEmail(String email);
	
	List<CustomerModel> findByAddress_City_CityName(String cityName);
	
	List<CustomerModel>findByAddress_City_Country_CountryName (String countryName);
	
	String addCustomer(CustomerModel newCustomerModel);
	
	CustomerModel findByAddress_Phone(String phone);
	
	CustomerModel updateFirstNameByCustomerId(int customerId, CustomerModel newFirstName);
	
	CustomerModel updateLastNameByCustomerId(int customerId, CustomerModel newLastName);
	
	CustomerModel updateEmailOfCustomerByCustomerId(int customerId, CustomerModel newEmail);
	
	CustomerModel updatePhoneNumberOfCustomerByCustomerId(int customerId, CustomerModel newPhoneNumber);
	
	List<CustomerModel> findByActive();
	
	List<CustomerModel> findByInActive();
	
	CustomerModel assignAddressToCustomer (int customerId, AddressModel addressModel);
	
	CustomerModel assignStoreToCustomer (int customerId,StoreModel storeModel);

}
