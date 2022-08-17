package com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesolunprojects.imdbcopyback.imdbdata.businessrule.exception.TitleBasicsNotFoundException;
import com.thesolunprojects.imdbcopyback.imdbdata.businessrule.usecase.GetAllTitleBasicsUC;
import com.thesolunprojects.imdbcopyback.imdbdata.businessrule.usecase.GetTitleBasicsByGenreUC;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.controller.model.GetTitleBasicsResponse;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.controller.model.GetTitleBasicsResponseMapper;

@Service
public class TitleBasicsController {

	@Autowired
	private GetAllTitleBasicsUC getAllTitleBasicsUC;

	@Autowired
	private GetTitleBasicsByGenreUC getTitleBasicsByGenreUC;

	public List<GetTitleBasicsResponse> getAllTitleBasics() {
		try {
			return getAllTitleBasicsUC
					.execute()
					.stream()
					.map(entity -> GetTitleBasicsResponseMapper.entityToResponse(entity))
					.collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			throw new TitleBasicsNotFoundException(e.getMessage());
		}
	}
	
	public List<GetTitleBasicsResponse> getTitleBasicsFilteredByGenre(String genre) {
		try {
			return getTitleBasicsByGenreUC
					.execute(genre)
					.stream()
					.map(entity -> GetTitleBasicsResponseMapper.entityToResponse(entity))
					.collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			throw new TitleBasicsNotFoundException(e.getMessage());
		}
	}
	
}
