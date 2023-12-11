package com.filmrental.service.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.filmrental.entity.Actor;
import com.filmrental.entity.Category;
import com.filmrental.entity.Film;
import com.filmrental.entity.Store;
import com.filmrental.model.ActorModel;
import com.filmrental.model.CategoryModel;
import com.filmrental.model.FilmModel;
import com.filmrental.model.StoreModel;

public class ConvertFilmEntityToFilmModel {
	public static  List<FilmModel> convertEntityToModel(List<Film> films) {
		List<FilmModel> filmModels = new ArrayList<>();
		for (Film film : films) {
			FilmModel filmModel = new FilmModel();
			BeanUtils.copyProperties(film, filmModel);
			List<ActorModel> allActorModels = new ArrayList<>();
			if (film.getAllActors() != null) {
				for (Actor actors : film.getAllActors()) {
					ActorModel actorModel = new ActorModel();
					BeanUtils.copyProperties(actors, actorModel);
					allActorModels.add(actorModel);
				}
			}
			filmModel.setAllActors(allActorModels);
			List<StoreModel> allStoreModels = new ArrayList<>();
			if (film.getAllStores() != null) {
				for (Store stores : film.getAllStores()) {
					StoreModel storeModel = new StoreModel();
					BeanUtils.copyProperties(stores, storeModel);
					allStoreModels.add(storeModel);
				}
			}
			filmModel.setAllStores(allStoreModels);
			List<CategoryModel> allCategoryModels = new ArrayList<>();
			if (film.getAllActors() != null) {
				for (Category categories : film.getAllCategorie()) {
					CategoryModel categoryModel = new CategoryModel();
					BeanUtils.copyProperties(categories, categoryModel);
					allCategoryModels.add(categoryModel);
				}
			}
			filmModel.setAllCategories(allCategoryModels);
			filmModels.add(filmModel);
		}
		return filmModels;
	}
	
	public static FilmModel copyFilmToFilmModel(Film film, Film updatedFilm) {
//		Film updatedFilm = filmRepo.save(film);
		FilmModel updatedFilmModel = new FilmModel();
		BeanUtils.copyProperties(updatedFilm, updatedFilmModel);
		List<ActorModel> allActorModels = new ArrayList<>();
		if (updatedFilm.getAllActors() != null) {
			for (Actor actors : updatedFilm.getAllActors()) {
				ActorModel actorModel = new ActorModel();
				BeanUtils.copyProperties(actors, actorModel);
				allActorModels.add(actorModel);
			}
		}
		updatedFilmModel.setAllActors(allActorModels);
		List<CategoryModel> allCategoryModels = new ArrayList<>();
		if (updatedFilm.getAllCategorie() != null) {
			for (Category categories : updatedFilm.getAllCategorie()) {
				CategoryModel categoryModel = new CategoryModel();
				BeanUtils.copyProperties(categories, categoryModel);
				allCategoryModels.add(categoryModel);
			}
		}
		updatedFilmModel.setAllCategories(allCategoryModels);
		List<StoreModel> allStoreModels = new ArrayList<>();
		if (updatedFilm.getAllStores() != null) {
			for (Store stores : updatedFilm.getAllStores()) {
				StoreModel storeModel = new StoreModel();
				BeanUtils.copyProperties(stores, storeModel);
				allStoreModels.add(storeModel);
			}
		}
		updatedFilmModel.setAllStores(allStoreModels);
		return updatedFilmModel;
	}
}
