package com.filmrental.model;

import java.sql.Timestamp;

import com.filmrental.entity.Category;
import com.filmrental.entity.Film;
import com.filmrental.entity.FilmCategoryId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategoryModel {
    private FilmCategoryId filmCategoryId;
    private Category category;
    private Film film;
	private Timestamp lastUpdate;
}
