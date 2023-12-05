package com.filmrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.Rental;

public interface RentalRepo extends JpaRepository<Rental, Integer>{

}
