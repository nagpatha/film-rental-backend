package com.filmrental.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.entity.Actor;
import com.filmrental.model.ActorModel;
import com.filmrental.repository.ActorRepo;

@Service
public class ActorServiceImpl implements ActorService{
	
	@Autowired
	private ActorRepo actorRepo;

	@Override
	public ActorModel findByFirstname(String firstName) {
		Actor actor= actorRepo.findByFirstName(firstName);
		ActorModel actorModel = new ActorModel();
		if(actor != null) {
			BeanUtils.copyProperties(actor, actorModel);
		}
		return actorModel;
	 
	}

	@Override
	public String addActor(ActorModel newActorModel) {
		
		Actor actor = new Actor();
		BeanUtils.copyProperties(newActorModel, actor);
		actorRepo.save(actor);
		actorRepo.flush();
		return "Actor added";
	}
}
