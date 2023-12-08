package com.filmrental.service;

import java.util.List;

import com.filmrental.model.FilmModel;

public interface FilmService {
	String addFilm(FilmModel newFilmModel);
	
	List<FilmModel>findByTitle(String title);
}
