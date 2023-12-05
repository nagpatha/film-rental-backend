package com.filmrental.model;

import java.sql.Timestamp;

import com.filmrental.entity.Actor;
import com.filmrental.entity.Film;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmActor {
	private Actor actor;
	private Film film;
	private Timestamp lastUpdate;
}
