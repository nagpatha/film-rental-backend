package com.filmrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
