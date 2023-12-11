package com.filmrental.entity;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
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
public class Inventory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private int inventoryId;

    @ManyToOne
    @JoinColumn(name = "film_id")
	private Film film;

    @ManyToOne
    @JoinColumn(name = "store_id")
	private Store store;
    
//	@OneToMany
//    @JoinColumn(name = "inventory_id")
//    private List<Rental> allRentals;

	@Column(name = "last_update")
	
	private Timestamp lastUpdate;
	
	@PrePersist
    private void setLastUpdate() {
        // Set lastUpdate to the current timestamp
        this.lastUpdate = Timestamp.from(Instant.now());
    }

}
