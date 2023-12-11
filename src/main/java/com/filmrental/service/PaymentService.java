package com.filmrental.service;

import java.util.List;

import com.filmrental.model.PaymentModel;

public interface PaymentService {
	
	List<PaymentModel> addPayment(PaymentModel paymentModel);
	
	String addNewPayment(PaymentModel newPayment);

}
