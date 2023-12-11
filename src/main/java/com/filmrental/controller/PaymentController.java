package com.filmrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.PaymentModel;
import com.filmrental.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired 
	private PaymentService paymentService;
	

	
	@PutMapping("add")
	public ResponseEntity<String> addNewPayment(@Valid @RequestBody PaymentModel newPayment) {
		String response = paymentService.addNewPayment(newPayment);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
}

