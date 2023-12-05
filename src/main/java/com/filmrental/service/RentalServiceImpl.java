package com.filmrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.repository.RentalRepo;

@Service
public class RentalServiceImpl implements RentalService {
	
	@Autowired
	private RentalRepo rentalRepo;
}
