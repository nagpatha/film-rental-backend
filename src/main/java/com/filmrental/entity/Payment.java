package com.filmrental.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int paymentId;

//	@ManyToOne
//	@JoinColumn(name = "customer_id")
//	private Customer customer;
//
//	@ManyToOne
//	@JoinColumn(name = "staff_id")
//	private Staff staff;
//
//	@ManyToOne
//	@JoinColumn(name = "rental_id")
//	private Rental rental;

	@Column(name = "amount", precision = 5, scale = 2)
	private BigDecimal amount;

	@Column(name = "payment_date")
	private Timestamp paymentDate;

	@Column(name = "last_update")
	private Timestamp lastUpdate;
}
