package com.filmrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.FilmModel;
import com.filmrental.service.FilmService;

@RestController
@RequestMapping("/api/films")
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	@PostMapping("/post")
	public String addFilm(@RequestBody FilmModel newFilmModel) {
		return filmService.addFilm(newFilmModel);
	}
	
	@GetMapping("/title/{title}") 
	public List<FilmModel> getFilmsByTitle(@PathVariable("title") String title){
		return filmService.findByTitle(title);
	}
}
