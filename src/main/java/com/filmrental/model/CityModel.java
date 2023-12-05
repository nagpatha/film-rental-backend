package com.filmrental.model;

import java.sql.Timestamp;

import com.filmrental.entity.Country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityModel {
	private int cityId;
	private String cityName;
	private Country country;
	private Timestamp lastUpdate;
}
