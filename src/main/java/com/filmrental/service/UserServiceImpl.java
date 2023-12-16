package com.filmrental.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.entity.Roles;
import com.filmrental.entity.User;
import com.filmrental.model.AuthModel;
import com.filmrental.model.RolesModel;
import com.filmrental.model.UserModel;
import com.filmrental.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	JwtService jwtService;

	@Override
	public AuthModel authenticateUser(UserModel userModel) {
		AuthModel authModel = new AuthModel();
		User fetchedUser = userRepo.findByUserName(userModel.getUserName());
		if(fetchedUser!=null && fetchedUser.getUserPassword().equals(userModel.getUserPassword())) {
			List<RolesModel> allRolesModel = new ArrayList<>();
			for(Roles eachRoles: fetchedUser.getAllRoles()) {	
				RolesModel roleModel = new RolesModel();
				BeanUtils.copyProperties(eachRoles, roleModel);
				allRolesModel.add(roleModel);
			}
			userModel.setAllRoles(allRolesModel);
			authModel.setUser(userModel);
			authModel.setToken(jwtService.generateToken(userModel));
		}else {
			throw new RuntimeException("Invalid Username/password!");
		} 
		return authModel;
	}
}
