package com.filmrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
