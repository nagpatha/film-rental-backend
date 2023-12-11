package com.filmrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.query.Param;


import com.filmrental.entity.Actor;
import com.filmrental.entity.Film;
import com.filmrental.model.FilmModel;



public interface FilmRepo extends JpaRepository<Film, Integer> {
	List<Film> findByTitle(String title);

	List<Film> findByReleaseYear(String releaseYear);

	List<Film> findByRentalDurationGreaterThan(long rd);

	List<Film> findByRentalRateGreaterThan(double rate);

	List<Film> findByLengthGreaterThan(long length);

	List<Film> findByRentalDurationLessThan(long rd);

	List<Film> findByRentalRateLessThan(double rate);

	List<Film> findByLengthLessThan(long length);

	List<Film> findByReleaseYearBetween(String startReleaseYear, String endReleaseYear);

	List<Film> findByRatingLessThan(String rating);

	List<Film> findByRatingGreaterThan(String rating);

	@Query("SELECT f FROM Film f JOIN f.language l WHERE l.name = :lang ")
	List<Film> findByLanguage(String lang);
	
	@Query("SELECT f.releaseYear, COUNT(f) FROM Film f GROUP BY f.releaseYear")
	List<Object[]> getCountOfFilmsByYear();

	@Query("SELECT f FROM Film f JOIN f.allCategorie c WHERE c.name = :categoryName")
	List<Film> findByCategoryName(String categoryName);


}
