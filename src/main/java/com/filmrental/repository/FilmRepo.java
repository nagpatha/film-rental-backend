package com.filmrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.filmrental.entity.Film;
import com.filmrental.model.FilmModel;

public interface FilmRepo extends JpaRepository<Film, Integer>{
	List<Film>findByTitle(String title);
//	@Query("select film_id from Film f where f.film_id=?1")
//	public Film getFilmsById(int id);
}
