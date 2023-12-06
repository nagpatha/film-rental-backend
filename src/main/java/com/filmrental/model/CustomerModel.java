package com.filmrental.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.Address;
import com.filmrental.entity.Payment;
import com.filmrental.entity.Rental;
import com.filmrental.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
	private int customerId;
	private Store store;
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	private String active;
	private Date createDate;
    private List<Rental> rentals;
    private List<Payment> payments;
	private Timestamp lastUpdate;
}
