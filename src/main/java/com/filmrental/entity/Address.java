package com.filmrental.entity;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "postal_code", nullable = false)
	private String postalCode;

	@Column(name = "phone")
	private String phone;

	@Column(name = "last_update")
	private Timestamp lastUpdate;


	
	@OneToMany
    @JoinColumn(name = "address_id")
	private List<Store> allStores ;
	
	


}
