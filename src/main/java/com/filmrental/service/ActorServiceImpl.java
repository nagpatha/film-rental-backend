package com.filmrental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.filmrental.entity.Actor;
import com.filmrental.entity.Film;
import com.filmrental.exception.ActorNotFoundException;
import com.filmrental.model.ActorModel;
import com.filmrental.model.FilmModel;
import com.filmrental.repository.ActorRepo;
import com.filmrental.repository.FilmRepo;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	ActorRepo actorRepo;

	@Autowired
	FilmRepo filmRepo;

	@Override
	public String addActor(ActorModel actorModel) {
		Actor actor = new Actor();
		BeanUtils.copyProperties(actorModel, actor);
		try {
			actorRepo.save(actor);
			return "Record Created Successfully";
		}
		catch(Exception e) {
			throw new ActorNotFoundException("Error adding actor");
		}
		
	}
	
	@Override
	public List<ActorModel> getAllActors() {
		 List<ActorModel> collect = actorRepo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
		if(collect.isEmpty()) {
			throw new ActorNotFoundException("Actor Not Exits");
		}
		 return collect;
	}

	@Override
	public List<ActorModel> getActorsByFirstName(String firstName) {
		List<ActorModel> collect = actorRepo.findByFirstName(firstName).stream().map(this::convertToDTO).collect(Collectors.toList());
		if(collect.isEmpty()) {
			throw new ActorNotFoundException("Actor First name not exits");
		}
		 return collect;
	}

	@Override
	public List<ActorModel> getActorsByLastName(String lastName) {
		List<ActorModel> collect = actorRepo.findByLastName(lastName).stream().map(this::convertToDTO).collect(Collectors.toList());
		if(collect.isEmpty()) {
			throw new ActorNotFoundException("Actor last name Not Exits");
		}
		 return collect;

	}

	private ActorModel convertToDTO(Actor actor) {
		ActorModel actorModel = new ActorModel();
		BeanUtils.copyProperties(actor, actorModel);
		return actorModel;
	}

	@Override
	public ActorModel updateLastNameOfActor(int actorId, ActorModel lastName) {
		Optional<Actor> optionalActor = actorRepo.findById(actorId);
		if (optionalActor.isPresent()) {
			Actor actor = optionalActor.get();
			actor.setLastName(lastName.getLastName());
			Actor updateActor = actorRepo.save(actor);
			ActorModel updatedActor = new ActorModel();
			BeanUtils.copyProperties(updateActor, updatedActor);
			return updatedActor;
		} else {
			 throw new ActorNotFoundException("Actor lastname not updated");
		}

	}

	@Override
	public ActorModel updateFirstNameOfActor(int actorId, ActorModel firstName) {
		Optional<Actor> optionalActor = actorRepo.findById(actorId);
		if (optionalActor.isPresent()) {
			Actor actor = optionalActor.get();
			actor.setLastName(firstName.getFirstName());
			Actor updateActor = actorRepo.save(actor);
			ActorModel updatedActor = new ActorModel();
			BeanUtils.copyProperties(updateActor, updatedActor);
			return updatedActor;
		} else {
			throw new ActorNotFoundException("Actor firstname not updated ");
		}
	}

	@Override
	public List<FilmModel> getFilmsByActorId(int actorId) {
		List<Actor> actors = actorRepo.getFilmsByActorId(actorId);
		System.out.println(actors);
		if (actors.isEmpty()) {
//	       throw new NotFoundException("Films not found for actor with ID: " + actorId);]
			throw new ActorNotFoundException("FilmByActorId Not Exits");
		}
		List<FilmModel> filmModels = new ArrayList<>();
		for (Actor actor : actors) {
			System.out.println("heloo" +actor);
			FilmModel filmModel = new 	FilmModel();
			System.out.println(actor.getFilms());
			System.out.println(actor.getFirstName());

			for(Film film : actor.getFilms()) {
				BeanUtils.copyProperties(film, filmModel);
				filmModels.add(filmModel);
			}
		}
		return filmModels;
	}
	
	 public List<Map<String, Object>> getTopActorsByFilmCount() {
	        List<Object[]> result = actorRepo.findTopActorsByFilmCount();

	        List<Map<String, Object>> collect = result.stream()
	                .map(row -> {
	                    Map<String, Object> map = Map.of(
	                            "id", row[0],
	                            "firstName", row[1],
	                            "lastName", row[2],
	                            "filmCount", row[3]
	                    );
	                    return map;
	                })
	                .collect(Collectors.toList());
			 if(collect.isEmpty()) {
				throw new ActorNotFoundException("Top Actors Not Exits");
			}
			 return collect;
	    }

	@Override
	public List<ActorModel> assignFilmToActors(int id, FilmModel filmModel) {
		Optional<Film> film = filmRepo.findById(id);
		List<Actor> actors = new ArrayList<>();
		for (ActorModel actorModel : filmModel.getAllActors()) {
			Actor actor = new Actor();
			BeanUtils.copyProperties(actorModel, actor);
			actors.add(actor);
		}
		actors.addAll(film.get().getAllActors());
		film.get().setAllActors(actors);
		try {
			filmRepo.saveAndFlush(film.get());
			return filmModel.getAllActors();
			}catch(Exception e) {
				throw new ActorNotFoundException("Assigning Film to Actor not Possible");
			}
		
	}	
}
	
	
	
	
	
