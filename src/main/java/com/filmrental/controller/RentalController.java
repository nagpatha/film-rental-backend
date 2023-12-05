package com.filmrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.service.RentalService;

@RestController
@RequestMapping("/api/actors/rental")
public class RentalController {
	@Autowired
	private RentalService rentalService;
}
