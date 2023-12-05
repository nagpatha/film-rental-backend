package com.filmrental.entity;

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
public class Staff {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private Long staffId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

    @ManyToOne
    @JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "picture", nullable = false)
	private String picture;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "store_id")
	private Long storeId;

	@Column(name = "active")
	private Long active;

	@Column(name = "username", length = 16)
	private String username;

	@Column(name = "password", nullable = false, length = 40)
	private String password;

	@Column(name = "last_update")
	private Timestamp lastUpdate;
}

//TODO 
//we will add foreign key of store table letter
