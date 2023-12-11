package com.filmrental.exception;

public class FilmNotFoundException extends RuntimeException{
	public FilmNotFoundException(String msg) {
		super(msg);
	}
}
