package com.filmrental.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.entity.Customer;
import com.filmrental.entity.Payment;
import com.filmrental.entity.Rental;
import com.filmrental.model.CustomerModel;
import com.filmrental.model.PaymentModel;
import com.filmrental.model.RentalModel;
import com.filmrental.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerrepo;

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
			customerModels.add(customerModel);
		}
		return customerModels;
	}

	@Override
	public CustomerModel findByEmail(String email) {
		Customer customer = customerrepo.findByEmail(email);
		CustomerModel customerModel = new CustomerModel();
		BeanUtils.copyProperties(customer, customerModel);
		return customerModel;
	}
}
