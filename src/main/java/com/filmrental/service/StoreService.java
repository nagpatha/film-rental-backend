package com.filmrental.service;
import java.util.List;

import com.filmrental.model.AddressModel;
import com.filmrental.model.CustomerModel;
import com.filmrental.model.StaffModel;
import com.filmrental.model.StoreModel;

public interface StoreService {
	
	StoreModel findByAddress_Phone(String phone);
	
	List<StoreModel> findByAddress_City_Country_CountryName(String countryName);
	
	String addNewStore(StoreModel newStore);
	
	StoreModel updatePhoneNumberOfStoreByStoreId(int storeId, StoreModel newPhoneNumber);

	List<CustomerModel> getCustomersOfStoreByStoreId(int storeId);
	
//	List<StaffModel> getStaffOfStoreByStoreId(int storeId);

	StoreModel assignAddressToStore(int storeId, AddressModel addressModel);

//	List<ManagerModel> assignStoreToManagers(int id, StoreModel storeModel);

	StoreModel assignManagerToStore(StoreModel updatedStore);

	List<StaffModel> getStaffOfStoreByStoreId(int storeId);

}
