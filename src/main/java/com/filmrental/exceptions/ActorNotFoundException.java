package com.filmrental.exceptions;

public class ActorNotFoundException extends RuntimeException{
	public ActorNotFoundException(String str) {
		super(str);
	}
 
}