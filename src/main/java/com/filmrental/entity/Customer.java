package com.filmrental.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;



	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email", nullable = false)
	private String email;


	@Column(name = "active", length = 1)
	private String active;

	@Column(name = "create_date")
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@OneToMany
    @JoinColumn(name = "customer_id")
	List<Rental> allRentals;
	
	@OneToMany
    @JoinColumn(name = "customer_id")
	List<Payment> allPayments;

	@Column(name = "last_update")
	private Timestamp lastUpdate;

}
