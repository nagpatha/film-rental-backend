package com.filmrental.service;

import java.util.List;
import java.util.Map;

import com.filmrental.entity.Actor;
import com.filmrental.model.ActorModel;
import com.filmrental.model.FilmModel;

public interface ActorService {
	
	String addActor(ActorModel actorModel);
	List<ActorModel> getActorsByFirstName(String firstName);
	List<ActorModel> getActorsByLastName(String lastName);
	ActorModel updateLastNameOfActor(int actorId, ActorModel lastName);
	ActorModel updateFirstNameOfActor(int actorId, ActorModel firstName);
	List<FilmModel> getFilmsByActorId(int actorId);
	public List<Map<String, Object>> getTopActorsByFilmCount();
	public List<ActorModel> assignFilmToActors(int id, FilmModel filmModel);
	 List<ActorModel> getAllActors();

}










