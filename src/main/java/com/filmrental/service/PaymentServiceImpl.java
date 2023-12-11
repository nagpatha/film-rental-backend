package com.filmrental.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.entity.Payment;
import com.filmrental.model.PaymentModel;
import com.filmrental.repository.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;

	@Override
	public List <PaymentModel> addPayment(PaymentModel paymentModel) {
		
		return null;
	}

	@Override
	public String addNewPayment(PaymentModel newPayment) {
		Payment payment = new Payment();
		BeanUtils.copyProperties(newPayment, payment);
		paymentRepo.save(payment);

		return "Record Created Successfully";
	}

	
	
}
