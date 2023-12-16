package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;
import com.filmrental.entity.Language;
import jakarta.validation.constraints.NotNull;
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
	@NotNull
	private String description;
	@NotNull
	private String releaseYear;
	private Language language;
	@NotNull
	private Language originalLanguage;
	private Long rentalDuration;
	private Double rentalRate;
	@NotNull
	private Long length;
	private Double replacementCost;
	@NotNull
	private String rating;
	@NotNull
	private String specialFeatures;
    private List<ActorModel> allActors;
    private List<CategoryModel> allCategories;
    private List<StoreModel> allStores;
	private Timestamp lastUpdate;
}
