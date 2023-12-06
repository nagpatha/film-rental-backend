package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.Film;
import com.filmrental.entity.Rental;
import com.filmrental.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryModel {
	private int inventoryId;
	private Film film;
	private Store store;
    private List<Rental> rentals;
	private Timestamp lastUpdate;
}
