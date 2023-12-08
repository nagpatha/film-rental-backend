package com.filmrental.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.Address;
import com.filmrental.entity.Payment;
import com.filmrental.entity.Rental;
import com.filmrental.entity.Store;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String active;
	private Date createDate;
	List<RentalModel> allRentals;
	List<PaymentModel> allPayments;
	private Timestamp lastUpdate;
}
