package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.City;
import com.filmrental.entity.Customer;
import com.filmrental.entity.Staff;
import com.filmrental.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {
	private int addressId;
	private String streetAddress;
	private String address2;
	private String district;
	private City city;
	private String postalCode;
	private String phone;
    private List<Customer> customers;
    private List<Staff> staffList;
    private List<Store> stores;
	private Timestamp lastUpdate;
}
