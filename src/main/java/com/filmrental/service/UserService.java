package com.filmrental.service;

import com.filmrental.model.AuthModel;
import com.filmrental.model.UserModel;

public interface UserService {
	AuthModel authenticateUser(UserModel userPojo);;
}
 