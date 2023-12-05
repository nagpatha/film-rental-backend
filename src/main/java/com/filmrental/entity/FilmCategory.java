package com.filmrental.entity;

import java.sql.Timestamp;

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
@Table(name = "film_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(FilmCategoryId.class)
public class FilmCategory {
	
	
	@EmbeddedId
    private FilmCategoryId filmCategoryId;
	
	@ManyToOne
	@MapsId("categoryId")
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category actor;
 
    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    private Film film;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
}
