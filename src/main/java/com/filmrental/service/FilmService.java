package com.filmrental.service;

import java.util.List;
import java.util.Map;

import com.filmrental.entity.Film;
import com.filmrental.model.ActorModel;
import com.filmrental.model.FilmModel;

public interface FilmService {
	
	Film findById(int id);
	
	String addFilm(FilmModel newFilmModel);

	List<FilmModel> findByTitle(String title);

	List<FilmModel> findByReleaseYear(String releaseYear);

	List<FilmModel> findByRentalDurationGreaterThan(long rd);

	List<FilmModel> findByRentalRateGreaterThan(double rate);

	List<FilmModel> findByLengthGreaterThan(long length);

	List<FilmModel> findByRentalDurationLessThan(long rd);

	List<FilmModel> findByRentalRateLessThan(double rate);

	List<FilmModel> findByLengthLessThan(long length);

	List<FilmModel> findByReleaseYearBetween(String startReleaseYear, String endReleaseYear);

	List<FilmModel> findByRatingLessThan(String rating);

	List<FilmModel> findByRatingGreaterThan(String rating);

	List<FilmModel> findByLanguage(String lang);
	
	Map<String,Long> getCountOfFilmsByYear();

	List<ActorModel> findAllActorsById(int filmId);

	List<FilmModel> findAllFilmBySpecialCategory(String category);
	
	FilmModel updateFilmTitle(int filmId, FilmModel newTitle);
	
	FilmModel updateFilmReleaseYear(int id, FilmModel newReleaseYear);

	FilmModel updateFilmRentalDuration(int filmId, FilmModel newRentalDuration);
	
	FilmModel updateFilmRentalRate(int filmId, FilmModel newRentalRate);
	
	FilmModel updateFilmRating(int filmId, FilmModel newRating);
	
	FilmModel updateFilmLanguage(int filmId, FilmModel newLanguage);
	
	FilmModel updateFilmCategory(int filmId, FilmModel newCategory);

	List<ActorModel> assignFilmToActors(int id, FilmModel filmModel);
}
