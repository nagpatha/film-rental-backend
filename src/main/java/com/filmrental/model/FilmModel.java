package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.Actor;
import com.filmrental.entity.Category;
import com.filmrental.entity.Language;
import com.filmrental.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmModel {
	private int filmId;
	private String title;
	private String description;
	private String releaseYear;
	private Language language;
	private Language originalLanguage;
	private Long rentalDuration;
	private Double rentalRate;
	private Long length;
	private Double replacementCost;
	private String rating;
	private String specialFeatures;
    private List<ActorModel> allActors;
    private List<CategoryModel> allCategories;
    private List<StoreModel> allStores;
	private Timestamp lastUpdate;
}
