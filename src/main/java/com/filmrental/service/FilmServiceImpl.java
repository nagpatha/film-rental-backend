package com.filmrental.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.filmrental.entity.Actor;
import com.filmrental.entity.Category;
import com.filmrental.entity.Film;
import com.filmrental.entity.Language;
import com.filmrental.entity.Store;
import com.filmrental.exception.FilmNotFoundException;
import com.filmrental.model.ActorModel;
import com.filmrental.model.CategoryModel;
import com.filmrental.model.FilmModel;
import com.filmrental.model.StoreModel;
import com.filmrental.repository.FilmRepo;
import com.filmrental.repository.LanguageRepo;
import com.filmrental.service.util.ConvertFilmEntityToFilmModel;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepo filmRepo;

	@Autowired
	private LanguageRepo languageRepo;

	@Override
	public Film findById(int id) {
		Optional<Film> film = filmRepo.findById(id);
		if (film.isPresent()) {
			return film.get();
		} else {
			throw new FilmNotFoundException("Film is not present with " + id + " film id ");
		}
	}

	@Override
	public String addFilm(FilmModel newFilmModel) {
		Film film = new Film();
		BeanUtils.copyProperties(newFilmModel, film);
		List<Category> filmCategories = new ArrayList<>();
		if (newFilmModel.getAllCategories() != null) {
			for (CategoryModel newCategories : newFilmModel.getAllCategories()) {
				Category category = new Category();
				BeanUtils.copyProperties(newCategories, category);
				filmCategories.add(category);
			}
		}
		film.setAllCategorie(filmCategories);
		List<Actor> filmActors = new ArrayList<>();
		if (newFilmModel.getAllActors() != null) {
			for (ActorModel newActors : newFilmModel.getAllActors()) {
				Actor actor = new Actor();
				BeanUtils.copyProperties(newActors, actor);
				filmActors.add(actor);
			}
		}
		film.setAllActors(filmActors);
		List<Store> stores = new ArrayList<>();
		if (newFilmModel.getAllStores() != null) {
			for (StoreModel newStore : newFilmModel.getAllStores()) {
				Store store = new Store();
				BeanUtils.copyProperties(newStore, store);
				stores.add(store);
			}
		}
		film.setAllStores(stores);
		Language language = newFilmModel.getLanguage();
		Language originalLanguage = newFilmModel.getOriginalLanguage();
		if (language != null && language.getLanguageId() == 0) {
			languageRepo.save(language);
		}
		if (originalLanguage != null && originalLanguage.getLanguageId() == 0) {
			languageRepo.save(originalLanguage);
		}
		film.setLanguage(language);
		film.setOriginalLanguage(originalLanguage);
		filmRepo.save(film);
		filmRepo.flush();
		return "Record Created Successfully";
	}

	@Override
	public List<FilmModel> findByTitle(String title) {
		List<Film> films = filmRepo.findByTitle(title);
		if (films.isEmpty()) {
			throw new FilmNotFoundException("Films are not present with " + title + " title ");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public List<FilmModel> findByReleaseYear(String releaseYear) {
		List<Film> films = filmRepo.findByReleaseYear(releaseYear);
		if (films.isEmpty()) {
			throw new FilmNotFoundException("Films are not present with " + releaseYear + "year");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public List<FilmModel> findByRentalDurationGreaterThan(long rd) {
		List<Film> films = filmRepo.findByRentalDurationGreaterThan(rd);
		if (films.isEmpty()) {
			throw new FilmNotFoundException("Films are not greater than " + rd + "rental duration");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public List<FilmModel> findByRentalRateGreaterThan(double rate) {
		List<Film> films = filmRepo.findByRentalRateGreaterThan(rate);
		if (films.isEmpty()) {
			throw new FilmNotFoundException("Films are not greater than " + rate + "rental rate");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public List<FilmModel> findByLengthGreaterThan(long length) {
		List<Film> films = filmRepo.findByLengthGreaterThan(length);
		if (films.isEmpty()) {
			throw new FilmNotFoundException("Films are not greater than  " + length + "length");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public List<FilmModel> findByRentalDurationLessThan(long rd) {
		List<Film> films = filmRepo.findByRentalDurationLessThan(rd);
		if (films.isEmpty()) {
			throw new FilmNotFoundException("Films are not less then " + rd + "rental duration");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public List<FilmModel> findByRentalRateLessThan(double rate) {
		List<Film> films = filmRepo.findByRentalRateLessThan(rate);
		if (films.isEmpty()) {
			throw new FilmNotFoundException("Films are not less then " + rate + "rental rate");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public List<FilmModel> findByLengthLessThan(long length) {
		List<Film> films = filmRepo.findByLengthLessThan(length);
		if (films.isEmpty()) {
			throw new FilmNotFoundException("Films are not less then " + length + "length");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public List<FilmModel> findByReleaseYearBetween(String startReleaseYear, String endReleaseYear) {
		List<Film> films = filmRepo.findByReleaseYearBetween(startReleaseYear, endReleaseYear);
		if (films.isEmpty()) {
			throw new FilmNotFoundException(
					"Films are not present between " + startReleaseYear + " to " + endReleaseYear + " endReleaseYear");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public List<FilmModel> findByRatingLessThan(String rating) {
		List<Film> films = filmRepo.findByRatingLessThan(rating);
		if (films.isEmpty()) {
			throw new FilmNotFoundException("Films are not less than  " + rating + " rating ");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);

	}

	@Override
	public List<FilmModel> findByRatingGreaterThan(String rating) {
		List<Film> films = filmRepo.findByRatingGreaterThan(rating);
		if (films.isEmpty()) {
			throw new FilmNotFoundException("Films are not greater than  " + rating + " rating ");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public List<FilmModel> findByLanguage(String lang) {
		List<Film> films = filmRepo.findByLanguage(lang);
		if (films.isEmpty()) {
			throw new FilmNotFoundException("Films are not present in " + lang + " Language ");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public Map<String, Long> getCountOfFilmsByYear() {
		List<Object[]> result = filmRepo.getCountOfFilmsByYear();
		return result.stream().collect(Collectors.toMap(obj -> (String) obj[0], obj -> (Long) obj[1]));
	}

	@Override
	public List<ActorModel> findAllActorsById(int filmId) {
		Optional<Film> films = filmRepo.findById(filmId);
		if (films.isPresent()) {
			Film film = films.get();
			List<ActorModel> allActorModels = new ArrayList<>();
			if (film.getAllActors() != null) {
				for (Actor actor : film.getAllActors()) {
					ActorModel actorModel = new ActorModel();
					BeanUtils.copyProperties(actor, actorModel);
					allActorModels.add(actorModel);
				}
			}
			return allActorModels;
		} else {
			throw new FilmNotFoundException("Film is not present with " + filmId + " film id ");
		}
	}

	@Override
	public List<FilmModel> findAllFilmBySpecialCategory(String category) {
		List<Film> films = filmRepo.findByCategoryName(category);
		if (films.isEmpty()) {
			throw new FilmNotFoundException(category + " film is not present ");
		}
		return ConvertFilmEntityToFilmModel.convertEntityToModel(films);
	}

	@Override
	public List<ActorModel> assignFilmToActors(int id, FilmModel filmModel) {
		Film film = findById(id);
		List<Actor> actors = new ArrayList<>();
		for (ActorModel actorModel : filmModel.getAllActors()) {
			Actor actor = new Actor();
			BeanUtils.copyProperties(actorModel, actor);
			actors.add(actor);
		}
		actors.addAll(film.getAllActors());
		film.setAllActors(actors);
		filmRepo.saveAndFlush(film);
		return filmModel.getAllActors();
	}

	@Override
	public FilmModel updateFilmTitle(int filmId, FilmModel newTitle) {
		Film film = findById(filmId);
		film.setTitle(newTitle.getTitle());
		Film updatedFilm = filmRepo.save(film);
		return ConvertFilmEntityToFilmModel.copyFilmToFilmModel(film, updatedFilm);
	}

	@Override
	public FilmModel updateFilmReleaseYear(int filmId, FilmModel newReleaseYear) {
		Film film = findById(filmId);
		film.setReleaseYear(newReleaseYear.getReleaseYear());
		Film updatedFilm = filmRepo.save(film);
		return ConvertFilmEntityToFilmModel.copyFilmToFilmModel(film, updatedFilm);
	}

	@Override
	public FilmModel updateFilmRentalDuration(int filmId, FilmModel newRentalDuration) {
		Film film = findById(filmId);
		film.setRentalDuration(newRentalDuration.getRentalDuration());
		Film updatedFilm = filmRepo.save(film);
		return ConvertFilmEntityToFilmModel.copyFilmToFilmModel(film, updatedFilm);
	}

	@Override
	public FilmModel updateFilmRentalRate(int filmId, FilmModel newRentalRate) {
		Film film = findById(filmId);
		film.setRentalRate(newRentalRate.getRentalRate());
		Film updatedFilm = filmRepo.save(film);
		return ConvertFilmEntityToFilmModel.copyFilmToFilmModel(film, updatedFilm);
	}

	@Override
	public FilmModel updateFilmRating(int filmId, FilmModel newRating) {
		Film film = findById(filmId);
		film.setRating(newRating.getRating());
		Film updatedFilm = filmRepo.save(film);
		return ConvertFilmEntityToFilmModel.copyFilmToFilmModel(film, updatedFilm);
	}

	@Override
	public FilmModel updateFilmLanguage(int filmId, FilmModel newLanguageModel) {
		Film film = findById(filmId);
		Language language = new Language();
		language.setLanguageId(newLanguageModel.getLanguage().getLanguageId());
		film.setLanguage(language);
//			Film updatedFilm = filmRepo.saveAndFlush(film);
		Film updatedFilm = filmRepo.save(film);
		return ConvertFilmEntityToFilmModel.copyFilmToFilmModel(film, updatedFilm);
	}

	// this is not working
	@Override
	public FilmModel updateFilmCategory(int filmId, FilmModel newCategory) {
		Film film = findById(filmId);
		List<CategoryModel> updatedCategories = newCategory.getAllCategories();
		System.out.println(updatedCategories);
		List<Category> filmCategories = new ArrayList<>();

		if (updatedCategories != null) {
			for (CategoryModel updatedCategory : updatedCategories) {
				Category category = new Category();
				BeanUtils.copyProperties(updatedCategory, category);
				filmCategories.add(category);
			}
		}
		film.setAllCategorie(filmCategories);
//			Film updatedFilm = filmRepo.saveAndFlush(film);
		Film updatedFilm = filmRepo.save(film);
		return ConvertFilmEntityToFilmModel.copyFilmToFilmModel(film, updatedFilm);
	}
}
