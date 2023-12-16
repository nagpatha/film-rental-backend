package com.filmrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.LanguageModel;
import com.filmrental.service.LanguageService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class LanguageController {
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/language/getAll")
	public ResponseEntity<List<LanguageModel>> findAll(){
		List<LanguageModel> response = languageService.findAll();
		return new ResponseEntity<List<LanguageModel>>(response, HttpStatus.OK);
	}
}
