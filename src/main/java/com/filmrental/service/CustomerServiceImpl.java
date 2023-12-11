package com.filmrental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.entity.Address;
import com.filmrental.entity.Customer;
import com.filmrental.entity.Payment;
import com.filmrental.entity.Rental;
import com.filmrental.entity.Store;
import com.filmrental.model.AddressModel;
import com.filmrental.model.CityModel;
import com.filmrental.model.CountryModel;
import com.filmrental.model.CustomerModel;
import com.filmrental.model.PaymentModel;
import com.filmrental.model.RentalModel;
import com.filmrental.model.StoreModel;
import com.filmrental.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerrepo;
	
	@Override
	public String addCustomer(CustomerModel newCustomerModel) {
	    Customer customer = new Customer();
	    BeanUtils.copyProperties(newCustomerModel, customer);
	    Address address = new Address();

	    BeanUtils.copyProperties(newCustomerModel.getAddress(), address);
	    customer.setAddress(address);
	    Store store = new Store();
	    BeanUtils.copyProperties(newCustomerModel.getStore(), store);
	    List<Store> stores = new ArrayList<>();
	    stores.add(store);
//	    customer.setStore(store);
	    customerrepo.save(customer);
	    customerrepo.flush();

	    return "Record Created Successfully";
	}
//	
//	@Override
//	public String addCustomer(CustomerModel newCustomerModel) {
//	    Customer customer = new Customer();
//	    BeanUtils.copyProperties(newCustomerModel, customer);
//
//	    Address address = new Address();
//	    AddressModel addressModel = newCustomerModel.getAddress();
//	    if (addressModel != null) {
//	        address = new Address();
//	        BeanUtils.copyProperties(addressModel, address);
//	    }
//
//	    customer.setAddress(address);
//
//	    Store store = new Store();
//	    StoreModel storeModel = newCustomerModel.getStore();
//	    if (storeModel != null) {
//	        store = new Store();
//	        BeanUtils.copyProperties(storeModel, store);
//	    }
//
//	    customer.setStore(store);
//
//	    customerrepo.save(customer);
//	    customerrepo.flush();
//
//	    return "Record Created Successfully";
//	}


	@Override
	public List<CustomerModel> findByLastName(String lastName) {

		List<Customer> customers = customerrepo.findByLastName(lastName);
		List<CustomerModel> customerModels = new ArrayList<>();
		for (Customer customer : customers) {
			CustomerModel customerModel = new CustomerModel();
			BeanUtils.copyProperties(customer, customerModel);

			List<RentalModel> rentalmodels = new ArrayList<>();
			if (customer.getAllRentals() != null) {
				for (Rental rental : customer.getAllRentals()) {
					RentalModel rentalModel = new RentalModel();
					BeanUtils.copyProperties(rental, rentalModel);
					List<PaymentModel> rentalPaymentModel = new ArrayList<>();
					if(rental.getPayments()!=null) {
						for(Payment payment : rental.getPayments()) {
							PaymentModel paymentModel = new PaymentModel();
							BeanUtils.copyProperties(payment, paymentModel);
							rentalPaymentModel.add(paymentModel);
						}
					}
					rentalModel.setPayments(rentalPaymentModel);
					rentalmodels.add(rentalModel);
				}
			}
			
			customerModel.setAllRentals(rentalmodels);
			
			
			List<PaymentModel> paymentmodels = new ArrayList<>();
			if (customer.getAllPayments() != null) {
				for (Payment payment : customer.getAllPayments()) {
					PaymentModel paymentModel = new PaymentModel();
					BeanUtils.copyProperties(payment, paymentModel);
					paymentmodels.add(paymentModel);
				}
			}
			
			customerModel.setAllPayments(paymentmodels);
			customerModels.add(customerModel);
		}
		return customerModels;
	}

	@Override
	public List<CustomerModel> findByFirstName(String firstName) {

		List<Customer> customers = customerrepo.findByFirstName(firstName);
		List<CustomerModel> customerModels = new ArrayList<>();
		for (Customer customer : customers) {
			CustomerModel customerModel = new CustomerModel();
			BeanUtils.copyProperties(customer, customerModel);

			List<RentalModel> rentalmodels = new ArrayList<>();
			if (customer.getAllRentals() != null) {
				for (Rental rental : customer.getAllRentals()) {
					RentalModel rentalModel = new RentalModel();
					BeanUtils.copyProperties(rental, rentalModel);
					List<PaymentModel> rentalPaymentModel = new ArrayList<>();
					if(rental.getPayments()!=null) {
						for(Payment payment : rental.getPayments()) {
							PaymentModel paymentModel = new PaymentModel();
							BeanUtils.copyProperties(payment, paymentModel);
							rentalPaymentModel.add(paymentModel);
						}
					}
					rentalModel.setPayments(rentalPaymentModel);
					rentalmodels.add(rentalModel);
				}
			}
			
			customerModel.setAllRentals(rentalmodels);
			
			
			List<PaymentModel> paymentmodels = new ArrayList<>();
			if (customer.getAllPayments() != null) {
				for (Payment payment : customer.getAllPayments()) {
					PaymentModel paymentModel = new PaymentModel();
					BeanUtils.copyProperties(payment, paymentModel);
					paymentmodels.add(paymentModel);
				}
			}
			
			customerModel.setAllPayments(paymentmodels);
			customerModels.add(customerModel);
		}
		return customerModels;
	}

	@Override
	public CustomerModel findByEmail(String email) {
		Customer customer = customerrepo.findByEmail(email);
		CustomerModel customerModel = new CustomerModel();
		BeanUtils.copyProperties(customer, customerModel);
		
		List<RentalModel> rentalModels = new ArrayList<>();
		if(customer.getAllRentals() !=null)	{
			
			 for (Rental rental : customer.getAllRentals()) {
                 RentalModel rentalModel = new RentalModel();
                 BeanUtils.copyProperties(rental, rentalModel);
                 
                 List<PaymentModel> rentalPaymentModel = new ArrayList<>();
					if(rental.getPayments()!=null) {
						for(Payment payment : rental.getPayments()) {
							PaymentModel paymentModel = new PaymentModel();
							BeanUtils.copyProperties(payment, paymentModel);
							rentalPaymentModel.add(paymentModel);
						}
						rentalModel.setPayments(rentalPaymentModel);
						rentalModels.add(rentalModel);
			 }					
		}
		
		customerModel.setAllRentals(rentalModels);
		
		
		List<PaymentModel> paymentModels = new ArrayList<>();
        if (customer.getAllPayments() != null) {
            for (Payment payment : customer.getAllPayments()) {
                PaymentModel paymentModel = new PaymentModel();
                BeanUtils.copyProperties(payment, paymentModel);
                // Copy payment-related properties or perform necessary logic
                paymentModels.add(paymentModel);
            }
        }
        customerModel.setAllPayments(paymentModels);
		
	}
		return customerModel;
}
	
	@Override
	public List<CustomerModel> findByAddress_City_CityName(String cityName) {
	    List<Customer> customers = customerrepo.findByAddress_City_CityName(cityName);
	    List<CustomerModel> customerModels = new ArrayList<>();

	    for (Customer customer : customers) {
	        CustomerModel customerModel = new CustomerModel();
	        BeanUtils.copyProperties(customer, customerModel);

	        if (customer.getAddress() != null) {
	            AddressModel addressModel = new AddressModel();
	            BeanUtils.copyProperties(customer.getAddress(), addressModel);
	            customerModel.setAddress(addressModel);

	            if (customer.getAddress().getCity() != null) {
	                CityModel cityModel = new CityModel();
	                BeanUtils.copyProperties(customer.getAddress().getCity(), cityModel);
	                addressModel.setCity(cityModel);
	            }
	        }

	        customerModels.add(customerModel);
	    }

	    return customerModels;
	}

	@Override
	public List<CustomerModel>findByAddress_City_Country_CountryName(String countryName) {
	    List<Customer> customers = customerrepo.findByAddress_City_Country_CountryName(countryName);
	    List<CustomerModel> customerModels = new ArrayList<>();

	    for (Customer customer : customers) {
	        CustomerModel customerModel = new CustomerModel();
	        BeanUtils.copyProperties(customer, customerModel);

	        if (customer.getAddress() != null) {
	            AddressModel addressModel = new AddressModel();
	            BeanUtils.copyProperties(customer.getAddress(), addressModel);
	            customerModel.setAddress(addressModel);

	            if (customer.getAddress().getCity() != null) {
	                CityModel cityModel = new CityModel();
	                BeanUtils.copyProperties(customer.getAddress().getCity(), cityModel);
	                addressModel.setCity(cityModel);

	                if (customer.getAddress().getCity().getCountry() != null) {
	                    CountryModel countryModel = new CountryModel();
	                    BeanUtils.copyProperties(customer.getAddress().getCity().getCountry(), countryModel);
	                    cityModel.setCountry(countryModel);
	                }
	            }
	        }

	        customerModels.add(customerModel);
	    }

	    return customerModels;
	}

	@Override
	public CustomerModel findByAddress_Phone(String phone) {
		Customer customer = customerrepo.findByAddress_Phone(phone);

        if (customer == null) {
            return null;
        }

        CustomerModel customerModel = new CustomerModel();
        BeanUtils.copyProperties(customer, customerModel);

        if (customer.getAddress() != null) {
            AddressModel addressModel = new AddressModel();
            BeanUtils.copyProperties(customer.getAddress(), addressModel);
            customerModel.setAddress(addressModel);

            if (customer.getAddress().getCity() != null) {
                CityModel cityModel = new CityModel();
                BeanUtils.copyProperties(customer.getAddress().getCity(), cityModel);
                addressModel.setCity(cityModel);
            }
        }

        return customerModel;
    }

	@Override
	public CustomerModel updateFirstNameByCustomerId(int customerId, CustomerModel newFirstName) {
		
		Optional<Customer> optionalCustomer = customerrepo.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFirstName(newFirstName.getFirstName());
            System.out.println(newFirstName.getFirstName());
            Customer updatedCustomer = customerrepo.save(customer);
            System.out.println(updatedCustomer.getFirstName());
            CustomerModel customerModel = new CustomerModel();
            BeanUtils.copyProperties(updatedCustomer, customerModel);
            return customerModel;
        } else {
            return null;
        } 

       
	}

	@Override
	public CustomerModel updateLastNameByCustomerId(int customerId, CustomerModel newLastName) {
		
		Optional<Customer> optionalCustomer = customerrepo.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setLastName(newLastName.getLastName());
            System.out.println(newLastName.getLastName());
            Customer updatedCustomer = customerrepo.save(customer);
            System.out.println(updatedCustomer.getLastName());
            CustomerModel customerModel = new CustomerModel();
            BeanUtils.copyProperties(updatedCustomer, customerModel);
            return customerModel;
        } else {
            return null;
        } 
	}

	@Override
	public CustomerModel updateEmailOfCustomerByCustomerId(int customerId, CustomerModel newEmail) {
		
		
		Optional<Customer> optionalCustomer = customerrepo.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setEmail(newEmail.getEmail());
            System.out.println(newEmail.getEmail());
            Customer updatedCustomer = customerrepo.save(customer);
            System.out.println(updatedCustomer.getEmail());
            CustomerModel customerModel = new CustomerModel();
            BeanUtils.copyProperties(updatedCustomer, customerModel);
            return customerModel;
        } else {
            return null;
        } 
	}

	@Override
	public CustomerModel updatePhoneNumberOfCustomerByCustomerId(int customerId, CustomerModel newPhoneNumber) {
	    Optional<Customer> optionalCustomer = customerrepo.findById(customerId);

	    if (optionalCustomer.isPresent()) {	    	
	    	Customer customer = optionalCustomer.get();
	    	System.out.println("test:" + customer);
	    	Address address = customer.getAddress();	    	
	    	address.setPhone(newPhoneNumber.getAddress().getPhone()); 	
	    	customer.setAddress(address);
	    	customerrepo.save(customer);
	    	CustomerModel customerModel = new CustomerModel();
	    	BeanUtils.copyProperties(customer, customerModel);
	    	return customerModel;	    	
	    }
	    else {
	        return null;
	    }
	}
	
	@Override
	public List<CustomerModel> findByActive() {
		
		 List<Customer> activeCustomers = customerrepo.findByActive("Y");
	        List<CustomerModel> activeCustomerModels = new ArrayList<>();
	        
	        for (Customer customer : activeCustomers) {
	            CustomerModel customerModel = new CustomerModel();
	            BeanUtils.copyProperties(customer, customerModel);
	            activeCustomerModels.add(customerModel);
	        }
	        
	        return activeCustomerModels;
	    }
	
	@Override
	 public List<CustomerModel> findByInActive(){
		List<Customer> InActiveCustomers = customerrepo.findByActive("N");
       List<CustomerModel> InActiveCustomerModels = new ArrayList<>();
       
       for (Customer customer : InActiveCustomers) {
           CustomerModel customerModel = new CustomerModel();
           BeanUtils.copyProperties(customer, customerModel);
           InActiveCustomerModels.add(customerModel);
       }
       
       return InActiveCustomerModels;
   }

	@Override
	public CustomerModel assignAddressToCustomer(int customerId, AddressModel addressModel) {
		
			Optional<Customer> optionalCustomer = customerrepo.findById(customerId);
			
			if(optionalCustomer.isPresent()) {
				Customer customer = optionalCustomer.get();
				Address address = new Address();
				BeanUtils.copyProperties(addressModel, address);
				customer.setAddress(address);
				customerrepo.saveAndFlush(customer);
				  
				CustomerModel customerModel = new CustomerModel();
				BeanUtils.copyProperties(customer, customerModel);
				return customerModel;
			}
			else {
				return null;
			}
	}


	@Override
	public CustomerModel assignStoreToCustomer(int customerId, StoreModel storeModel) {
		
		Optional<Customer> optionalCustomer = customerrepo.findById(customerId);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			Store store = new Store();
			BeanUtils.copyProperties(storeModel, store);
			customer.setStore(store);
			customerrepo.saveAndFlush(customer);
			  
			CustomerModel customerModel = new CustomerModel();
			BeanUtils.copyProperties(customer, customerModel);
			return customerModel;
		}
		else {
			return null;
		}
	}		
	
}





	
	

