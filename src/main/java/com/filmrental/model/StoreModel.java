package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

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
	private String phone;
	private Timestamp lastUpdate;
	private List<CustomerModel> allCustomer;
	private List<StaffModel> allStaff;
	private AddressModel address;
}
