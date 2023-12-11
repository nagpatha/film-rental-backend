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
public class Rental {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_id")
	private int rentalId;

	@Column(name = "rental_date")
	private Timestamp rentalDate;


	@Column(name = "return_date", nullable = false)
	private Timestamp returnDate;


	@OneToMany
    @JoinColumn(name = "rental_id")
    private List<Payment> payments;

//    @OneToMany
//    @JoinColumn(name ="rental_id")
//    private List<Payment> payments;
    
	@Column(name = "last_update")
	private Timestamp lastUpdate;
}
