package com.filmrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUserName(String name);
}
