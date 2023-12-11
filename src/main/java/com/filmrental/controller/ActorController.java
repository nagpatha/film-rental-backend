package com.filmrental.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.entity.Actor;
import com.filmrental.model.ActorModel;
import com.filmrental.model.FilmModel;
import com.filmrental.service.ActorService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/actors")
public class ActorController {

    @Autowired
    ActorService actorService;
    
    @PostMapping("/post")
    public ResponseEntity<String> addActor(@Valid @RequestBody ActorModel actorModel){
    	String response=actorService.addActor(actorModel);
    	return new ResponseEntity<String>(response,HttpStatus.CREATED);
    }
    
    @GetMapping("/all")
	public List<ActorModel> getAllActors() {
		return actorService.getAllActors();
    }

    @GetMapping("/firstname/{fn}")
    public ResponseEntity<List<ActorModel>> getActorsByFirstName(@PathVariable String fn){
    	List<ActorModel> actors=actorService.getActorsByFirstName(fn);
    	return ResponseEntity.ok(actors);
    }
    
    @GetMapping("/lastname/{ln}")
    public ResponseEntity<List<ActorModel>> getActorsByLastName(@PathVariable String ln){
    	List<ActorModel> actors=actorService.getActorsByLastName(ln);
    	return ResponseEntity.ok(actors);
    }
    
    @PutMapping("/update/lastname/{id}")
    public ActorModel updateLastNameOfActor(@Valid @PathVariable int id, @RequestBody ActorModel lastName) {
    	return actorService.updateLastNameOfActor(id, lastName);
    }
    
    @PutMapping("/update/firstname/{id}")
    public ActorModel updateFirstNameOfActor(@PathVariable @Valid int id, @RequestBody ActorModel firstName) {
    	return actorService.updateLastNameOfActor(id, firstName);
    }

    @GetMapping("/films/{id}")
    public ResponseEntity<List<FilmModel>> getFilmsByActorId(@PathVariable("id") int id) {
    	List<FilmModel> response = actorService.getFilmsByActorId(id);
    	return new ResponseEntity<List<FilmModel>>(response, HttpStatus.OK);
	}
    
    
    @GetMapping
    public List<Map<String, Object>> getTopActorsByFilmCount() {
    	return actorService.getTopActorsByFilmCount();
    }
    
    @PutMapping("/film/{id}")
    public List<ActorModel> assignFilmToActors( @PathVariable("id") @Valid int id, FilmModel filmModel){
    	return actorService.assignFilmToActors(id, filmModel);
    	
    }
}
 
