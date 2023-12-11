package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.Address;
import com.filmrental.entity.Country;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    private List<Address> allAddresses;
    private CountryModel country;
	private Timestamp lastUpdate;
}
