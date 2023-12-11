package com.filmrental.model;

import java.sql.Timestamp;

import com.filmrental.entity.Actor;
import com.filmrental.entity.Film;
import com.filmrental.entity.FilmActorId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmActorModel {
    private FilmActorId filmActorId;
    private Actor actor;
    private Film film;
	private Timestamp lastUpdate;
}
