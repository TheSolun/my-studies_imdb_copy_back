package com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway;

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

import com.thesolunprojects.imdbcopyback.imdbdata.domain.TitleBasics;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway.TitleBasicsGateway;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway.repository.TitleBasicsRepository;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway.repository.model.TitleBasicsModel;

@ExtendWith(MockitoExtension.class)
class TitleBasicsGatewayTest {

	@InjectMocks
	private TitleBasicsGateway titleGateway;
	
	@Mock
	private TitleBasicsRepository titleBasicsRepository;
	
	@Test
	@DisplayName("Should list all titles basics")
	void getAllTitlesWillSuccess() {
		final TitleBasicsModel modelTitle = new TitleBasicsModel(
			"tt0000001","short","Carmencita","Carmencita",0,"1894","N","1","Documentary","Short","N"
		);
		final List<TitleBasicsModel> modelsTitlesList = new ArrayList<TitleBasicsModel>();
		modelsTitlesList.add(modelTitle);
		modelsTitlesList.add(modelTitle);
		modelsTitlesList.add(modelTitle);
		
		final TitleBasics entityTitle = new TitleBasics(
			"tt0000001","short","Carmencita","Carmencita",false,"1894",null,1,"Documentary","Short",null
		);
		final List<TitleBasics> entitysTitlesList = new ArrayList<TitleBasics>();
		entitysTitlesList.add(entityTitle);
		entitysTitlesList.add(entityTitle);
		entitysTitlesList.add(entityTitle);
		
		when(titleBasicsRepository.findAll()).thenReturn(modelsTitlesList);
		
		final List<TitleBasics> gatewayTitlesList = titleGateway.getAllTitles();
		
		assertNotNull(gatewayTitlesList);
		assertFalse(gatewayTitlesList.isEmpty());
		assertEquals(entitysTitlesList, gatewayTitlesList);
	}
	
	@Test
	@DisplayName("Should return empty titles list when genre is empty")
	void getTitlesFilteredByGenreWithEmptyGenreWillReturnEmptyTitlesList() {
		final String genre = " ";
		
		List<TitleBasics> gatewayTitlesList = titleGateway.getTitlesFilteredByGenre(genre);
		
		assertNotNull(gatewayTitlesList);
		assertTrue(gatewayTitlesList.isEmpty());
	}
	
	@Test
	@DisplayName("Should return Empty Optional when genre is null")
	void getTitlesFilteredByGenreWithNullGenreWillReturnEmptyTitlesList() {
		final String genre = null;
		
		List<TitleBasics> gatewayTitlesList = titleGateway.getTitlesFilteredByGenre(genre);
		
		assertNotNull(gatewayTitlesList);
		assertTrue(gatewayTitlesList.isEmpty());
	}
	
	@Test
	@DisplayName("Should list genres titles basics")
	void getTitlesFilteredByGenreWillSuccess() {
		final String genre = "Documentary";
		
		final TitleBasicsModel modelTitle = new TitleBasicsModel(
			"tt0000001","short","Carmencita","Carmencita",0,"1894","N","1",genre,"Short","N"
		);
		final List<TitleBasicsModel> modelsTitlesList = new ArrayList<TitleBasicsModel>();
		modelsTitlesList.add(modelTitle);
		modelsTitlesList.add(modelTitle);
		modelsTitlesList.add(modelTitle);
		
		final TitleBasics entityTitle = new TitleBasics(
			"tt0000001","short","Carmencita","Carmencita",false,"1894",null,1,genre,"Short",null
		);
		final List<TitleBasics> entitysTitlesList = new ArrayList<TitleBasics>();
		entitysTitlesList.add(entityTitle);
		entitysTitlesList.add(entityTitle);
		entitysTitlesList.add(entityTitle);
		
		when(titleBasicsRepository.findByGenre(genre)).thenReturn(modelsTitlesList);
		
		final List<TitleBasics> gatewayTitlesList = titleGateway.getTitlesFilteredByGenre(genre);
		
		assertNotNull(gatewayTitlesList);
		assertFalse(gatewayTitlesList.isEmpty());
		assertEquals(entitysTitlesList, gatewayTitlesList);
	}

}
