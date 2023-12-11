package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.filmrental.entity.City;
import com.filmrental.entity.Customer;
import com.filmrental.entity.Staff;
import com.filmrental.entity.Store;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@NotNull
	private String address2;
	private String district;
	@NotNull
	private String postalCode;
	private String phone;
    private List<Customer> customers;
    private List<Staff> staffList;
	private Timestamp lastUpdate;

	private List<Store> allStores ;
	private CityModel city;
	private AddressModel address;
}
