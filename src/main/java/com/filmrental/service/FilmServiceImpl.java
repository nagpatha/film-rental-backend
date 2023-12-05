package com.filmrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.repository.FilmRepo;

@Service
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	private FilmRepo filmRepo;
}
