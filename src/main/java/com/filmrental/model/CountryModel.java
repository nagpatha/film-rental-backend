package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.filmrental.entity.City;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryModel {
	private int countryId;
	private String countryName;
	@NotNull
	private Timestamp lastUpdate;
	private List<CityModel> allCities; 
	private StoreModel store;
}
