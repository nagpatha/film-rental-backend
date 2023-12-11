package com.filmrental.model;
 
import java.sql.Timestamp;
import java.util.List;

import java.util.List;
 
import com.filmrental.entity.Address;
import com.filmrental.entity.Payment;
import com.filmrental.entity.Rental;
import com.filmrental.entity.Store;
import com.filmrental.entity.Payment;

import com.filmrental.entity.Rental;

import com.filmrental.entity.Store;
 
import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;

import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.Setter;
 
 
@Getter

@Setter

@NoArgsConstructor

@AllArgsConstructor

public class StaffModel {

	private int staffId;

	private String firstName;

	private String lastName;

	private String picture;

	private String email;
 
	private Long active;
 
	private String username;
 
	private String password;
 
	private List<PaymentModel> allPayments;

    private List<RentalModel> rentals;
 

	private Timestamp lastUpdate;
	
	private AddressModel address;

}
