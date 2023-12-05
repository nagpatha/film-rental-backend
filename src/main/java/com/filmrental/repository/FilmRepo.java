package com.filmrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.Film;

public interface FilmRepo extends JpaRepository<Film, Integer>{

}
