package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.Address;
import com.filmrental.entity.Inventory;
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
	private Staff managerStaff;
	private Address address;
    private List<Inventory> inventories;
    private List<Staff> staffList;
	private Timestamp lastUpdate;
}
