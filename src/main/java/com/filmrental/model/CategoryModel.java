package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.FilmCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {
	private int categoryId;
	private String name;
	private List<FilmCategory> filmCategories;
	private Timestamp lastUpdate;

}
