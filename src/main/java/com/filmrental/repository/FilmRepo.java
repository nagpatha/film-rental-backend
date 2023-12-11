package com.filmrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.Film;
import com.filmrental.model.FilmModel;

public interface FilmRepo extends JpaRepository<Film, Integer>{
	List<Film>findByTitle(String title);
}
