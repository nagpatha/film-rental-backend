package com.filmrental.service;

import java.util.ArrayList;
import java.util.List;

import com.filmrental.entity.Address;
import com.filmrental.entity.Customer;
import com.filmrental.entity.Staff;
import com.filmrental.entity.Store;
import com.filmrental.exception.StoreNotFoundException;

import java.util.Optional;

import org.apache.catalina.Manager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import org.springframework.stereotype.Service;

import com.filmrental.model.AddressModel;
import com.filmrental.model.CityModel;
import com.filmrental.model.CountryModel;
import com.filmrental.model.CustomerModel;
import com.filmrental.model.StaffModel;
import com.filmrental.model.StoreModel;
import com.filmrental.repository.StoreRepo;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepo storeRepo;
	
	
	@Override
	public String addNewStore(StoreModel newStore) {
		Store store = new Store();
		BeanUtils.copyProperties(newStore, store);
		storeRepo.save(store);

		return "Record Created Successfully";
	}
	
	
	@Override
	public StoreModel assignAddressToStore(int storeId, AddressModel addressModel) {
//		System.out.println(addressModel);
		Optional<Store> optionalStore = storeRepo.findById(storeId);
		if (optionalStore.isPresent()) {
			Store store = optionalStore.get();
			Address address = new Address();
			BeanUtils.copyProperties(addressModel, address);
			store.setAddress(address);
			storeRepo.saveAndFlush(store);
			StoreModel storeModel = new StoreModel();
			BeanUtils.copyProperties(store, storeModel);
			return storeModel;
		} else {
			throw new StoreNotFoundException("Address not found");
		}
	}

	
	
	@Override
	public List<StoreModel> findByAddress_City_Country_CountryName(String countryName) {

		List<Store> stores = storeRepo.findByAddress_City_Country_CountryName(countryName);
		if (stores.isEmpty()) {
			throw new StoreNotFoundException("country not found");
		}
		List<StoreModel> storeModels = new ArrayList<>();

		for (Store store : stores) {
			StoreModel storeModel = new StoreModel();
			BeanUtils.copyProperties(store, storeModel);

			if (store.getAddress() != null) {
				AddressModel addressModel = new AddressModel();
				BeanUtils.copyProperties(store.getAddress(), addressModel);
				storeModel.setAddress(addressModel);

				if (store.getAddress().getCity() != null) {
					CityModel cityModel = new CityModel();
					BeanUtils.copyProperties(store.getAddress().getCity(), cityModel);
					addressModel.setCity(cityModel);

					if (store.getAddress().getCity().getCountry() != null) {
						CountryModel countryModel = new CountryModel();
						BeanUtils.copyProperties(store.getAddress().getCity().getCountry(), countryModel);
						cityModel.setCountry(countryModel);
					}
				}
			}

			storeModels.add(storeModel);
		}

		return storeModels;
	}

	@Override
	public StoreModel findByAddress_Phone(String phone) {
		Store store = storeRepo.findByAddress_Phone(phone);

		if (store == null) {

			throw new StoreNotFoundException("phone not found");

		}

		StoreModel storeModel = new StoreModel();

		BeanUtils.copyProperties(store, storeModel);

		if (store.getAddress() != null) {

			AddressModel addressModel = new AddressModel();

			BeanUtils.copyProperties(store.getAddress(), addressModel);

			storeModel.setAddress(addressModel);

			if (store.getAddress().getCity() != null) {

				CityModel cityModel = new CityModel();

				BeanUtils.copyProperties(store.getAddress().getCity(), cityModel);

				addressModel.setCity(cityModel);

			}

		}

		return storeModel;
	}

	
	

	@Override
	public StoreModel updatePhoneNumberOfStoreByStoreId(int storeId, StoreModel newPhoneNumber) {
		Optional<Store> optionalCustomer = storeRepo.findById(storeId);

		if (optionalCustomer.isPresent()) {
			Store store = optionalCustomer.get();
			System.out.println("test:" + store);
			Address address = store.getAddress();
			address.setPhone(newPhoneNumber.getAddress().getPhone());
			store.setAddress(address);
			storeRepo.save(store);
			StoreModel storeModel = new StoreModel();
			BeanUtils.copyProperties(store, storeModel);
			return storeModel;
		} else {
			throw new StoreNotFoundException("phone number not found");
		}
	}
	
	
	@Override
	public List<StaffModel> getStaffOfStoreByStoreId(int storeId) {
		Optional<Store> optionalStaff = storeRepo.findById(storeId);

		if (optionalStaff.isPresent()) {
			List<Staff> staffs = optionalStaff.get().getAllStaff();
			List<StaffModel> staffModels = new ArrayList<>();
			for (Staff staff : staffs) {
				StaffModel staffModel = new StaffModel();
				BeanUtils.copyProperties(staff, staffModel);
				staffModels.add(staffModel);
			}
			return staffModels;
		}
		else {
			throw new StoreNotFoundException("staff not found");
		}
	}


	@Override
	public List<CustomerModel> getCustomersOfStoreByStoreId(int storeId) {
		Optional<Store> optionalCustomer = storeRepo.findById(storeId);

		if (optionalCustomer.isPresent()) {
			List<Customer> customers = optionalCustomer.get().getAllCustomers();
			List<CustomerModel> customerModels = new ArrayList<>();
			for (Customer customer : customers) {
				CustomerModel customerModel = new CustomerModel();
				BeanUtils.copyProperties(customer, customerModel);
				customerModels.add(customerModel);
			}
			return customerModels;
		}
		else {
			throw new StoreNotFoundException("customer not found");
		}
	}

	

	

	@Override
	public StoreModel assignManagerToStore(StoreModel updatedStore) {

		return null;
	}

//	@Override
//	public List<ManagerModel> assignStoreToManagers(int id, StoreModel storeModel) {
//		Store store = findById(id);
//		List<Manager> actors = new ArrayList<>();
//		for (ManagerModel actorModel : filmModel.getAllActors()) {
//			Manager manager = new Manager();
//			BeanUtils.copyProperties(managerModel, manager);
//			actors.add(manager);
//		}
//		managers.addAll(store.getAllmanagers());
//		store.setAllManagers(managers);
//		storeRepo.saveAndFlush(store);
//		return storeModel.getAllManagers();
//		return null;
//	}
}
