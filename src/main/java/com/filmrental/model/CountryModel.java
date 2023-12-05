package com.filmrental.model;

import java.sql.Timestamp;

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
	private Timestamp lastUpdate;
}
