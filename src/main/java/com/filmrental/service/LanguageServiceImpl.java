package com.filmrental.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.entity.Language;
import com.filmrental.exception.ResourceNotFoundException;
import com.filmrental.model.LanguageModel;
import com.filmrental.repository.LanguageRepo;

@Service
public class LanguageServiceImpl implements LanguageService {
	@Autowired
	private LanguageRepo languageRepo;

	@Override
	public List<LanguageModel> findAll() {
		List<Language> allLanguage = languageRepo.findAll();
		if(allLanguage.isEmpty()) {
			throw new ResourceNotFoundException("Language empty");
		}
		List<LanguageModel> allLanguageModel = new ArrayList<>();
		for(Language language: allLanguage) {
			LanguageModel languageModel = new LanguageModel();
			BeanUtils.copyProperties(language, languageModel);
			allLanguageModel.add(languageModel);
		}
		return allLanguageModel;
	}
}
