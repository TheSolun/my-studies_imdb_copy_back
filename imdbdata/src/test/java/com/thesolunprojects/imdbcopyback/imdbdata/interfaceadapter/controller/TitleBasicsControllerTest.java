package com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.thesolunprojects.imdbcopyback.imdbdata.businessrule.usecase.GetAllTitleBasicsUC;
import com.thesolunprojects.imdbcopyback.imdbdata.businessrule.usecase.GetTitleBasicsByGenreUC;
import com.thesolunprojects.imdbcopyback.imdbdata.domain.TitleBasics;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.controller.model.GetTitleBasicsResponse;

@ExtendWith(MockitoExtension.class)
class TitleBasicsControllerTest {

	@InjectMocks
	private TitleBasicsController titleController;
	
	@Mock
	private GetAllTitleBasicsUC getAllTitleBasicsUC;
	
	@Mock
	private GetTitleBasicsByGenreUC getTitleBasicsByGenreUC;
	
	@Test
	@DisplayName("Should list all titles basics")
	void getAllTitleBasicsWillSuccess() {
		final TitleBasics entityTitle = new TitleBasics(
			"tt0000001","short","Carmencita","Carmencita",false,"1894","N",1,"Documentary","Short","N"
		);
		final List<TitleBasics> entitysTitlesList = new ArrayList<TitleBasics>();
		entitysTitlesList.add(entityTitle);
		entitysTitlesList.add(entityTitle);
		entitysTitlesList.add(entityTitle);
		
		final GetTitleBasicsResponse responseTitle = new GetTitleBasicsResponse(
			entityTitle.getTconst(),entityTitle.getTitleType(),entityTitle.getPrimaryTitle(),
			entityTitle.getOriginalTitle(),entityTitle.isAdult(),entityTitle.getStartYear(),
			entityTitle.getEndYear(),entityTitle.getRuntimeMinutes(),entityTitle.getGenre1(),
			entityTitle.getGenre2(),entityTitle.getGenre3()
		);
		final List<GetTitleBasicsResponse> responsesTitlesList = new ArrayList<GetTitleBasicsResponse>();
		responsesTitlesList.add(responseTitle);
		responsesTitlesList.add(responseTitle);
		responsesTitlesList.add(responseTitle);
		
		when(getAllTitleBasicsUC.execute()).thenReturn(entitysTitlesList);
		
		final List<GetTitleBasicsResponse> controllerTitlesList = titleController.getAllTitleBasics();
		
		assertNotNull(controllerTitlesList);
		assertFalse(controllerTitlesList.isEmpty());
		assertEquals(responsesTitlesList, controllerTitlesList);
	}
	
	@Test
	@DisplayName("Should return empty titles list when genre is empty")
	void getTitlesFilteredByGenreWithEmptyGenreWillReturnEmptyTitlesList() {
		final String genre = " ";
		
		List<GetTitleBasicsResponse> controllerTitlesList = titleController.getTitleBasicsFilteredByGenre(genre);
		
		assertNotNull(controllerTitlesList);
		assertTrue(controllerTitlesList.isEmpty());
	}
	
	@Test
	@DisplayName("Should return empty titles list when genre is null")
	void getTitlesFilteredByGenreWithNullGenreWillReturnEmptyTitlesList() {
		final String genre = null;
		
		List<GetTitleBasicsResponse> controllerTitlesList = titleController.getTitleBasicsFilteredByGenre(genre);
		
		assertNotNull(controllerTitlesList);
		assertTrue(controllerTitlesList.isEmpty());
	}

	@Test
	@DisplayName("Should list genres titles basics")
	void getTitleBasicsFilteredByGenreWillSuccess() {
		final String genre = "Documentary";
		
		final TitleBasics entityTitle = new TitleBasics(
			"tt0000001","short","Carmencita","Carmencita",false,"1894","N",1,genre,"Short","N"
		);
		final List<TitleBasics> entitysTitlesList = new ArrayList<TitleBasics>();
		entitysTitlesList.add(entityTitle);
		entitysTitlesList.add(entityTitle);
		entitysTitlesList.add(entityTitle);
		
		final GetTitleBasicsResponse responseTitle = new GetTitleBasicsResponse(
			entityTitle.getTconst(),entityTitle.getTitleType(),entityTitle.getPrimaryTitle(),
			entityTitle.getOriginalTitle(),entityTitle.isAdult(),entityTitle.getStartYear(),
			entityTitle.getEndYear(),entityTitle.getRuntimeMinutes(),entityTitle.getGenre1(),
			entityTitle.getGenre2(),entityTitle.getGenre3()
		);
		final List<GetTitleBasicsResponse> responsesTitlesList = new ArrayList<GetTitleBasicsResponse>();
		responsesTitlesList.add(responseTitle);
		responsesTitlesList.add(responseTitle);
		responsesTitlesList.add(responseTitle);
		
		when(getTitleBasicsByGenreUC.execute(genre)).thenReturn(entitysTitlesList);
		
		final List<GetTitleBasicsResponse> controllerTitlesList = titleController.getTitleBasicsFilteredByGenre(genre);
		
		assertNotNull(controllerTitlesList);
		assertFalse(controllerTitlesList.isEmpty());
		assertEquals(responsesTitlesList, controllerTitlesList);
	}
	
}
