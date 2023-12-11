package com.filmrental.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
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
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private int storeId;


//	@ManyToOne
//	@JoinColumn(name = "manager_staff_id")
//	private Staff manager;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;


	@Column(name = "last_update")
	private Timestamp lastUpdate;
	

//	@Column(name = "city")
//	private String city;
	
	
	

	
	@OneToMany
    @JoinColumn(name = "store_id")
	List<Staff> allStaff;

	@OneToMany(mappedBy = "store")
	List<Customer> allCustomers;

}
