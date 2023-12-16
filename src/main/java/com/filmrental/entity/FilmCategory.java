package com.filmrental.entity;

import java.sql.Timestamp;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
public class FilmCategory {

	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name="filmId", column = @Column(name="film_id")),
		@AttributeOverride(name="categoryId", column = @Column(name="category_id"))
	})
    private FilmCategoryId filmCategoryId;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
}
