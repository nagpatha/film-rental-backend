package com.filmrental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.model.PaymentModel;
import com.filmrental.repository.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;

	@Override
	public List <PaymentModel> addPayment(PaymentModel paymentModel) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
