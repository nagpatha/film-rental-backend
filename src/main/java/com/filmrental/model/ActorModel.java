package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.filmrental.entity.FilmActor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

	
	@NotNull(message = "First Name should not be null")
    @NotBlank(message = "First Name is required")
    private String firstName;
   
	@NotNull(message = "Last Name should not be null")
	@NotBlank(message = "Last Name is required")
	private String lastName;
	
    //private List<FilmActor> filmActors;
    
	@NotNull(message = "Last Update should not be null")
	private Timestamp lastUpdate;
}
