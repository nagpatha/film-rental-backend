package com.filmrental.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.filmrental.entity.Address;
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
	private Timestamp lastUpdate;
}
