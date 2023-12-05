package com.filmrental.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Language {
	@Id
	@Column(name = "language_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int languageId;
	private String name;
	@Column(name = "last_update")
	private Timestamp lastUpdate;
}
