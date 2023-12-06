package com.filmrental.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.entity.Actor;
import com.filmrental.entity.Category;
import com.filmrental.entity.Film;
import com.filmrental.entity.FilmActor;
import com.filmrental.entity.FilmCategory;
import com.filmrental.entity.Inventory;
import com.filmrental.entity.Language;
import com.filmrental.entity.Store;
import com.filmrental.model.ActorModel;
import com.filmrental.model.CategoryModel;
import com.filmrental.model.FilmModel;
import com.filmrental.model.StoreModel;
import com.filmrental.repository.FilmRepo;
import com.filmrental.repository.LanguageRepo;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepo filmRepo;

	@Autowired
	private LanguageRepo languageRepo;

	@Override
	public String addFilm(FilmModel newFilmModel) {
		Film film = new Film();
		BeanUtils.copyProperties(newFilmModel, film);
		List<Category> filmCategories = new ArrayList<>();
		if(newFilmModel.getAllCategories() != null) {
			for(CategoryModel newCategories: newFilmModel.getAllCategories()) {
				Category category = new Category();
				BeanUtils.copyProperties(newCategories, category);
				filmCategories.add(category);
			} 
		}
		film.setAllCategorie(filmCategories);
		
		List<Actor> filmActors = new ArrayList<>();
		if( newFilmModel.getAllActors() != null) {
			for(ActorModel newActors :  newFilmModel.getAllActors()) {
				Actor actor = new Actor();
				BeanUtils.copyProperties(newActors, actor);
				filmActors.add(actor);
			}
		}
		film.setAllActors(filmActors);
		
		List<Store> stores = new ArrayList<>();
		if(newFilmModel.getAllStores() !=null) {
			for(StoreModel newStore: newFilmModel.getAllStores() ){
				Store store = new Store();
				BeanUtils.copyProperties(newStore, store);
				stores.add(store);
			}
		}
		film.setAllStores(stores);
		
//		FilmActor filmActor = new FilmActor();
		// Ensure that language and originalLanguage are saved entities
		Language language = newFilmModel.getLanguage();
		Language originalLanguage = newFilmModel.getOriginalLanguage();

		if (language != null && language.getLanguageId() == 0) {
			languageRepo.save(language);
		}

		if (originalLanguage != null && originalLanguage.getLanguageId() == 0) {
			languageRepo.save(originalLanguage);
		}

		// Set the saved Language entities in the Film entity
		film.setLanguage(language);
		film.setOriginalLanguage(originalLanguage);

		filmRepo.save(film);
		filmRepo.flush();
		return "Record Created Successfully";
	}

	@Override
	public List<FilmModel> findByTitle(String title) {
		
		List<Film> films = filmRepo.findByTitle(title);
        List<FilmModel> filmModels = new ArrayList<>();

        for (Film film : films) {
            FilmModel filmModel = new FilmModel();
            BeanUtils.copyProperties(film, filmModel);
            filmModels.add(filmModel);
        }

        return filmModels;
	}
}
