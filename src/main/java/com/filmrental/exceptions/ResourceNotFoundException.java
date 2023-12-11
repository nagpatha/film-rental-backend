package com.filmrental.exceptions;

public class ResourceNotFoundException extends RuntimeException  {
	
public ResourceNotFoundException(String str) {
	super(str);
}
}
