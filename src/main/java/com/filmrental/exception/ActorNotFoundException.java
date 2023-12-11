package com.filmrental.exception;

public class ActorNotFoundException extends RuntimeException{
	public ActorNotFoundException(String str) {
		super(str);
	}
 
}