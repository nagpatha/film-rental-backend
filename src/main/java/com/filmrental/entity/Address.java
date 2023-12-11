package com.filmrental.entity;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;

	@Column(name = "address")
	private String streetAddress;

	@Column(name = "address2")
	private String address2;

	@Column(name = "district")
	private String district;

	@Column(name = "postal_code", nullable = false)
	private String postalCode;

	@Column(name = "phone")
	private String phone;
	
//	@OneToMany(mappedBy = "address")
//    private List<Customer> customers;
	

//	@OneToMany
//    @JoinColumn(name = "address_id")
//    private List<Staff> staffList;


	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
//	@OneToMany
//    @JoinColumn(name = "address_id")
//	private List<Store> allStores ;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	
	
}
