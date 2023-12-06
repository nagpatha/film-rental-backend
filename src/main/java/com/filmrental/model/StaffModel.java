package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.Address;
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
public class StaffModel {
	private int staffId;
	private String firstName;
	private String lastName;
	private Address address;
	private String picture;
	private String email;

//	@Column(name = "store_id")
//	private Long storeId;
	private Long active;
	private String username;
	private String password;
    private Store store;
    private List<Rental> rentals;
	private Timestamp lastUpdate;
}
