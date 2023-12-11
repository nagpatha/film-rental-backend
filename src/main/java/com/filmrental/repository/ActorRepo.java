package com.filmrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.Actor;

public interface ActorRepo extends JpaRepository<Actor, Integer> {
	Actor findByFirstName(String firstName);
}
