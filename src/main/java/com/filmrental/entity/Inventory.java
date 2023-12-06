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
public class Inventory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private int inventoryId;
//
//    @ManyToOne
//    @JoinColumn(name = "film_id")
//	private Film film;

//    @ManyToOne
//    @JoinColumn(name = "store_id")
//	private Store store;
    
//    @OneToMany(mappedBy = "inventory")
//    private List<Rental> rentals;

	@Column(name = "last_update")
	private Timestamp lastUpdate;

}
