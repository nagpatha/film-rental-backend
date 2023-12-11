package com.filmrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmRentalApplication.class, args);
		System.out.println("server is up and running");
	}
}
   