package com.filmrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.entity.Language;

public interface LanguageRepo extends JpaRepository<Language, Integer> {

}
