package com.filmrental.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.filmrental.entity.Actor;
import com.filmrental.entity.Film;
import com.filmrental.entity.Language;
import com.filmrental.exception.FilmNotFoundException;
import com.filmrental.model.ActorModel;
import com.filmrental.model.FilmModel;
import com.filmrental.repository.FilmRepo;
import com.filmrental.repository.LanguageRepo;

@SpringBootTest
public class FilmServiceImplTest {

	@Mock
	FilmRepo filmRepo;

	@Mock
	LanguageRepo languageRepo;

	@InjectMocks
	FilmServiceImpl filmServiceImpl;

	@Test
	public void testFindByTitle() {
		String title = "film";
		List<Film> stubAllFilms = new ArrayList<>();
		stubAllFilms.add(new Film(1, "film1", "2018", "hhh", null, null, null, null, null, null, title, title, null,
				null, null, null));
//		stubAllFilms.add(new Film(1, "film1", "2018", "hhh", null, null, null, null, null, null, title, title, null,
//				null, null, null));
		when(filmRepo.findByTitle(title)).thenReturn(stubAllFilms);
		List<FilmModel> expectedFilModels = new ArrayList<>();
		expectedFilModels.add(new FilmModel(1, "film1", "2018", "hhh", null, null, null, null, null, null, title, title,
				null, null, null, null));
		List<FilmModel> actualFilModels = filmServiceImpl.findByTitle(title);
		assertEquals(expectedFilModels.size(), actualFilModels.size());
		verify(filmRepo).findByTitle(title);
	}

	@Test
	public void testFindByTitleException() {
		String title = "Film1";
		List<Film> stubAllFilms = new ArrayList<>();
		when(filmRepo.findByTitle(title)).thenReturn(stubAllFilms);
		String expectedMessage = "Films are not present with " + title + " title ";
		FilmNotFoundException actualException = assertThrows(FilmNotFoundException.class,
				() -> filmServiceImpl.findByTitle(title));
		String actualMessage = actualException.getMessage();
		assertEquals(expectedMessage, actualMessage);
		verify(filmRepo).findByTitle(title);
	}

	@Test
	public void testFindByLengthGreaterThan() {
		long length = 5;
		List<Film> stubAllFilms = new ArrayList<>();
		stubAllFilms.add(
				new Film(5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
		when(filmRepo.findByLengthGreaterThan(length)).thenReturn(stubAllFilms);
		List<FilmModel> expectedFilModels = new ArrayList<>();
		expectedFilModels.add(new FilmModel(5, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null));
		List<FilmModel> actualFilModels = filmServiceImpl.findByLengthGreaterThan(length);
		assertEquals(expectedFilModels.size(), actualFilModels.size());
		verify(filmRepo).findByLengthGreaterThan(length);
	}

	@Test
	public void testFindByLengthGreaterThanException() {
		long length = 6;
		List<Film> stubAllFilms = new ArrayList<>();
		when(filmRepo.findByLengthGreaterThan(length)).thenReturn(stubAllFilms);
		String expectedMessage = "Films are not present with \" + title + \" title";
		FilmNotFoundException actualException = assertThrows(FilmNotFoundException.class,
				() -> filmServiceImpl.findByLengthGreaterThan(length));
		String actualMessage = actualException.getMessage();
		assertEquals(expectedMessage, actualMessage);
		verify(filmRepo).findByLengthGreaterThan(length);
	}

	@Test
	public void testFindByRatingGreaterThan() {
		String rating = "5.5";
		List<Film> stubAllFilms = new ArrayList<>();
		stubAllFilms.add(
				new Film(5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
		when(filmRepo.findByRatingGreaterThan(rating)).thenReturn(stubAllFilms);
		List<FilmModel> expectedFilModels = new ArrayList<>();
		expectedFilModels.add(new FilmModel(5, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null));
		List<FilmModel> actualFilModels = filmServiceImpl.findByRatingGreaterThan(rating);
		assertEquals(expectedFilModels.size(), actualFilModels.size());
		verify(filmRepo).findByRatingGreaterThan(rating);
	}

	@Test
	public void testFindByRatingGreaterThanException() {
		String rating = "5.5";
		List<Film> stubAllFilms = new ArrayList<>();
		when(filmRepo.findByRatingGreaterThan(rating)).thenReturn(stubAllFilms);
		String expectedMessage = "Films are not greater than  " + rating + " rating ";
		FilmNotFoundException actualException = assertThrows(FilmNotFoundException.class,
				() -> filmServiceImpl.findByRatingGreaterThan(rating));
		String actualMessage = actualException.getMessage();
		assertEquals(expectedMessage, actualMessage);
		verify(filmRepo).findByRatingGreaterThan(rating);
	}

	@Test
	public void testAddFilm() {
		FilmModel newFilmModel = new FilmModel(1, "FilmTitle", "2022", "Description", null, null, null, null, null,
				null, "Category1", "Category2", null, null, null, null);

		when(languageRepo.save(any(Language.class))).thenReturn(new Language());
		when(filmRepo.save(any(Film.class))).thenReturn(new Film());

		String result = filmServiceImpl.addFilm(newFilmModel);

		assertEquals("Record Created Successfully", result);
		verify(languageRepo, times(2)).save(any(Language.class));
		verify(filmRepo).save(any(Film.class));
		verify(filmRepo).flush();
	}

	@Test
	public void testFindAllActorsById() {
		int filmId = 1;
		Film film = new Film();
		film.setFilmId(filmId);
		List<Actor> actors = new ArrayList<>();
		actors.add(new Actor(1, "salman", "khan", null, null));
		actors.add(new Actor(2, "shahrukh", "khan", null, null));
		film.setAllActors(actors);

		when(filmRepo.findById(filmId)).thenReturn(Optional.of(film));

		List<ActorModel> expectedActorModels = new ArrayList<>();
		expectedActorModels.add(new ActorModel(1, "salman", "khan", null));
		expectedActorModels.add(new ActorModel(2, "shahrukh", "khan", null));

		List<ActorModel> actualActorModels = filmServiceImpl.findAllActorsById(filmId);

		assertEquals(expectedActorModels.size(), actualActorModels.size());
	}
}
