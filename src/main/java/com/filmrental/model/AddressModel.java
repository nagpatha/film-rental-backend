package com.filmrental.model;

import java.sql.Timestamp;

import com.filmrental.entity.City;

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
	private Timestamp lastUpdate;

}
