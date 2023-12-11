package com.filmrental.service;

import com.filmrental.model.ActorModel;

public interface ActorService {
	ActorModel findByFirstname(String firstName);
	String addActor(ActorModel actorModel);
}
