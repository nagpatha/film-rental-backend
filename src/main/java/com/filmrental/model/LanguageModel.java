package com.filmrental.model;

import java.sql.Timestamp;
import java.util.List;

import com.filmrental.entity.Film;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageModel {
	private int languageId;
	private String name;
	
	private Timestamp lastUpdate;
}
