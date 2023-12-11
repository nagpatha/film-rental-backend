package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.Customer;
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
public class RentalModel {
	private int rentalId;
	private Timestamp rentalDate;
	private Inventory inventory;
	private Customer customer;
	private Timestamp returnDate;
	private Staff staff;
	private List<PaymentModel> payments;
	private Timestamp lastUpdate;
}
