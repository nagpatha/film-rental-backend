package com.filmrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer>{

}
