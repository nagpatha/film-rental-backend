package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.FilmActor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorModel {
	private int actorId;
	private String firstName;
	private String lastName;
    private List<FilmActor> filmActors;
	private Timestamp lastUpdate;
}