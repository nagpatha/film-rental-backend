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
public class Staff {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private int staffId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "picture", nullable = false)
	private String picture;

	@Column(name = "email", nullable = false)
	private String email;

//	@Column(name = "store_id")
//	private Long storeId;

	@Column(name = "active")
	private Long active;

	@Column(name = "username", length = 16)
	private String username;

	@Column(name = "password", nullable = false, length = 40)
	private String password;
	
	@OneToMany
    @JoinColumn(name = "staff_id")
	private List<Payment> allPayments;
	
	@OneToMany
    @JoinColumn(name = "staff_id")
    private List<Rental> allRentals;

	@Column(name = "last_update")
	private Timestamp lastUpdate;
}

