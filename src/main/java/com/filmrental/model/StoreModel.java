package com.filmrental.model;

import java.sql.Timestamp;

import com.filmrental.entity.Address;
import com.filmrental.entity.Staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreModel {
	private int storeId;
	private Staff manager;
	private Address address;
	private Timestamp lastUpdate;
}
