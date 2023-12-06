package com.filmrental.entity;

import java.sql.Timestamp;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "film_actor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmActor {
	
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name="filmId", column = @Column(name="film_id")),
		@AttributeOverride(name="actorId", column = @Column(name="actor_id"))
	})
    private FilmActorId filmActorId;
	
//	@ManyToOne
//	@MapsId("actorId")
//    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
//    private Actor actor;
 
//    @ManyToOne
//    @MapsId("filmId")
//    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
//    private Film film;

	@Column(name = "last_update")
	private Timestamp lastUpdate = new Timestamp(System.currentTimeMillis()); // Set a default value;
}
