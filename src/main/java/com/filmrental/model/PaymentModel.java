package com.filmrental.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.filmrental.entity.Customer;
import com.filmrental.entity.Rental;
import com.filmrental.entity.Staff;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentModel {
	@Column(name = "payment_id")
	private int paymentId;
	private int customerId;
	private int rentalId;
	private int staffId;
	private BigDecimal amount;
	private Timestamp paymentDate;
	private Timestamp lastUpdate;
}
