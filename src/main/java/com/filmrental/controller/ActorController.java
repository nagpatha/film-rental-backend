package com.filmrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.ActorModel;
import com.filmrental.service.ActorService;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	
	@GetMapping("firstname/{fn}")
	public ActorModel findByFirstname(@PathVariable String fn) {
		return actorService.findByFirstname(fn);
	}
	
	@PostMapping("/post")
	public String addActor(@RequestBody ActorModel newActorModel) {
		return actorService.addActor(newActorModel);
	}
}
