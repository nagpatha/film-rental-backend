package com.filmrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.service.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
}
