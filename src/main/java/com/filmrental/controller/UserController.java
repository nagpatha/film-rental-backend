package com.filmrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.AuthModel;
import com.filmrental.model.UserModel;
import com.filmrental.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public AuthModel authenticateUser(@RequestBody UserModel userModel) {
		return userService.authenticateUser(userModel);
	}
}
  