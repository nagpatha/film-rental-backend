package com.filmrental.model;

import java.sql.Timestamp;

import com.filmrental.entity.Address;

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
	private byte[] picture;
	private String email;
	private Long storeId;
	private Long active;
	private String username;
	private String password;
	private Timestamp lastUpdate;
}
