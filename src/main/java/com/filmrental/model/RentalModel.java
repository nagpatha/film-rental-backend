package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.Customer;
import com.filmrental.entity.Inventory;
import com.filmrental.entity.Payment;
import com.filmrental.entity.Staff;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	private Timestamp returnDate;
    private List<PaymentModel> payments;
	private Timestamp lastUpdate;
}
