package com.filmrental.entity;
 
import java.sql.Timestamp;
import java.util.List;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Film {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private int filmId;
 
	private String title;
 
	private String description;
 
	@Column(name = "release_year")
	private String releaseYear;
 
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;
 
	@ManyToOne
	@JoinColumn(name = "original_language_id", nullable = false)
	private Language originalLanguage;
 
	@Column(name = "rental_duration")
	private Long rentalDuration;
 
	@Column(name = "rental_rate")
	private Double rentalRate;
 
	private Long length;
 
	@Column(name = "replacement_cost")
	private Double replacementCost;


	@Column(name = "rating", nullable = false)

	private String rating;
 
	@Column(name = "special_features")
	private String specialFeatures;

 
//	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
//    private List<FilmActor> filmActors;
//	
//	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
//    private List<FilmCategory> filmCategories;
//	
//	@OneToMany(mappedBy = "film" , cascade = CascadeType.ALL)
//    private List<Inventory> inventories;

	@ManyToMany
	@JoinTable(
	    name = "film_actor",
	    joinColumns = @JoinColumn(name = "film_id"),
	    inverseJoinColumns = @JoinColumn(name = "actor_id")
	)
	private List<Actor> allActors;
 
	@ManyToMany
	@JoinTable(
	    name = "film_category",
	    joinColumns = @JoinColumn(name = "film_id"),
	    inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private List<Category> allCategorie;
	@ManyToMany
	@JoinTable(
	    name = "inventory",
	    joinColumns = @JoinColumn(name = "film_id"),
	    inverseJoinColumns = @JoinColumn(name = "store_id")
	)
	private List<Store> allStores;

	@Column(name = "last_update")
	private Timestamp lastUpdate;
}

