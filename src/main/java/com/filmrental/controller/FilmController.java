package com.filmrental.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.entity.Film;
import com.filmrental.model.ActorModel;
import com.filmrental.model.FilmModel;
import com.filmrental.service.FilmService;
import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/films")
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Film> findById(@PathVariable int id) {
		Film response = filmService.findById(id);
		return new ResponseEntity<Film>(response, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<FilmModel> getFilmById(@PathVariable int id) {
		FilmModel response = filmService.getFilmById(id);
		return new ResponseEntity<FilmModel>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<FilmModel>> findAllFilms(){
		List<FilmModel> response = filmService.findAllFilms();
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}

	@PostMapping("/post")
	public ResponseEntity<String> addFilm(@Valid @RequestBody FilmModel newFilmModel) {
		String response = filmService.addFilm(newFilmModel);
		return new ResponseEntity<String>(response, HttpStatus.CREATED); 
	}

	@GetMapping("/title/{title}")
	public ResponseEntity<List<FilmModel>> getFilmsByTitle(@PathVariable("title") String title) {
		List<FilmModel> response = filmService.findByTitle(title);
		return new ResponseEntity<List<FilmModel>>(response,HttpStatus.OK);
	}

	@GetMapping("/year/{year}")
	public ResponseEntity<List<FilmModel>> findByReleaseYear(@PathVariable("year") String year) {
		List<FilmModel> response = filmService.findByReleaseYear(year);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/duration/gt/{rd}")
	public ResponseEntity<List<FilmModel>> findByRentalDurationGreaterThan(@PathVariable("rd") long rd) {
		List<FilmModel> response = filmService.findByRentalDurationGreaterThan(rd);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}
 
	@GetMapping("/rate/gt/{rate}")
	public ResponseEntity<List<FilmModel>> findByRentalRateGreaterThan(@PathVariable("rate") double rate) {
		List<FilmModel> response = filmService.findByRentalRateGreaterThan(rate);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/length/gt/{length}")
	public ResponseEntity<List<FilmModel>> findByLengthGreaterThan(@PathVariable("length") long length) {
		List<FilmModel> response = filmService.findByLengthGreaterThan(length);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/duration/lt/{rd}")
	public ResponseEntity<List<FilmModel>> findByRentalDurationLessThan(@PathVariable("rd") long rd){
		List<FilmModel> response = filmService.findByRentalDurationLessThan(rd);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/rate/lt/{rate}")
	public ResponseEntity<List<FilmModel>> findByRentalRateLessThan(@PathVariable("rate") double rate){
		List<FilmModel> response = filmService.findByRentalRateLessThan(rate);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}

	@GetMapping("/length/lt/{length}")
	public ResponseEntity<List<FilmModel>> findByLengthLessThan(@PathVariable("length") long length){
		List<FilmModel> response = filmService.findByLengthLessThan(length);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/betweenyear/{from}/{to}")
	public ResponseEntity<List<FilmModel>> findByReleaseYearBetween(@PathVariable("from") String startReleaseYear, @PathVariable("to") String endReleaseYear){
		List<FilmModel> response = filmService.findByReleaseYearBetween(startReleaseYear, endReleaseYear);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/rating/lt/{rating}")
	public ResponseEntity<List<FilmModel>> findByRatingLessThan(@PathVariable("rating") String rating ){
		List<FilmModel> response = filmService.findByRatingLessThan(rating);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/rating/gt/{rating}")
	public ResponseEntity<List<FilmModel>> findByRatingGreaterThan(@PathVariable("gt") String rating ){
		List<FilmModel> response = filmService.findByRatingGreaterThan(rating);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	} 
	
	@GetMapping("/language/{lang}")
	public ResponseEntity<List<FilmModel>> findByLanguage(@PathVariable("lang") String lang){
		List<FilmModel> response = filmService.findByLanguage(lang);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/countbyyear")
	public ResponseEntity<Map<String,Long>> getCountOfFilmsByYear(){
		Map<String,Long> response = filmService.getCountOfFilmsByYear();
		return new ResponseEntity<Map<String,Long>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/actors")
	public ResponseEntity<List<ActorModel>> findAllActorsById(@PathVariable("id") int id){
		List<ActorModel> response = filmService.findAllActorsById(id);
		return new ResponseEntity<List<ActorModel>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/category/{category}")
	 public ResponseEntity<List<FilmModel>> findAllFilmBySpecialCategory(@PathVariable("category") String category){
		List<FilmModel> response = filmService.findAllFilmBySpecialCategory(category);
		return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	 }
	
	@PutMapping("/{id}/actors")
	public ResponseEntity<List<ActorModel>> assignFilmToActors(@PathVariable int id, @RequestBody FilmModel filmModel){
		List<ActorModel> response = filmService.assignFilmToActors(id, filmModel);
		return new ResponseEntity<List<ActorModel>>(response, HttpStatus.OK);
	}
	 
	@PutMapping("/update/title/{id}")
	public ResponseEntity<FilmModel> updateFilmByTitle(@PathVariable int id, @RequestBody FilmModel newTitle) {
		FilmModel response = filmService.updateFilmTitle(id, newTitle);
		return new ResponseEntity<FilmModel>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update/releaseyear/{id}")
	public ResponseEntity<FilmModel> updateFilmReleaseYear(@PathVariable int id,@RequestBody FilmModel newReleaseYear) {
		FilmModel response =  filmService.updateFilmReleaseYear(id, newReleaseYear);
		return new ResponseEntity<FilmModel>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update/rentaldurtion/{id}")
	public ResponseEntity<FilmModel> updateFilmRentalDuration(@PathVariable int id,@RequestBody FilmModel newRentalDuration) {
		FilmModel response = filmService.updateFilmRentalDuration(id, newRentalDuration);
		return new ResponseEntity<FilmModel>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update/rentalrate/{id}")
	public ResponseEntity<FilmModel> updateFilmRentalRate(@PathVariable int id, @RequestBody FilmModel newRentalRate) {
		FilmModel response = filmService.updateFilmRentalRate(id, newRentalRate);
		return new ResponseEntity<FilmModel>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update/rating/{id}")
	public ResponseEntity<FilmModel> updateFilmRating(@PathVariable int id,@Valid  @RequestBody FilmModel newRating) {
		FilmModel response = filmService.updateFilmRating(id, newRating);
		return new ResponseEntity<FilmModel>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update/language/{id}")
	public ResponseEntity<FilmModel> updateFilmLanguage(@PathVariable int id, @RequestBody FilmModel newLanguage) {
		FilmModel response = filmService.updateFilmLanguage(id, newLanguage);
		return new ResponseEntity<FilmModel>(response, HttpStatus.OK);
	}
	 
	@PutMapping("/update/category/{id}")
	public ResponseEntity<FilmModel> updateFilmCategory(@PathVariable int id,@RequestBody FilmModel newCategory) {
		FilmModel response = filmService.updateFilmCategory(id, newCategory);
		return new ResponseEntity<FilmModel>(response, HttpStatus.OK);
	}
}