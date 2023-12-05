package com.filmrental.model;

import java.sql.Timestamp;

import com.filmrental.entity.Category;
import com.filmrental.entity.Film;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategory {
	private Film film;
	private Category category;
	private Timestamp lastUpdate;
}
