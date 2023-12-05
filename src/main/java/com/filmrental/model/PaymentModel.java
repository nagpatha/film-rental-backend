package com.filmrental.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.filmrental.entity.Customer;
import com.filmrental.entity.Rental;
import com.filmrental.entity.Staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentModel {
	private int paymentId;
	private Customer customer;
	private Staff staff;
	private Rental rental;
	private BigDecimal amount;
	private Timestamp paymentDate;
	private Timestamp lastUpdate;
}
