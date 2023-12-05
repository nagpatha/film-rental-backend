package com.filmrental.model;

import java.sql.Timestamp;

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
	private Timestamp lastUpdate;
}
