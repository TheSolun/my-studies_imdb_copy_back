package com.thesolunprojects.imdbcopyback.imdbdata.infra.springresources;

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

import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.controller.TitleBasicsController;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.controller.model.GetTitleBasicsResponse;

@ExtendWith(MockitoExtension.class)
class SpringTitleBasicsResourceTest {

	@InjectMocks
	private SpringTitleBasicsResource springTitleBasicsResource;
	
	@Mock
	private TitleBasicsController titleBasicsController;
	
	@Test
	@DisplayName("Should list all titles basics")
	void getAllTitleBasicsWillSuccess() {
		final GetTitleBasicsResponse responseTitle = new GetTitleBasicsResponse(
			"tt0000001","short","Carmencita","Carmencita",false,"1894","N",1,"Documentary","Short","N"
		);
		final List<GetTitleBasicsResponse> responsesTitlesList = new ArrayList<GetTitleBasicsResponse>();
		responsesTitlesList.add(responseTitle);
		responsesTitlesList.add(responseTitle);
		responsesTitlesList.add(responseTitle);
		
		when(titleBasicsController.getAllTitleBasics()).thenReturn(responsesTitlesList);
		
		final List<GetTitleBasicsResponse> resourceTitlesList = springTitleBasicsResource.getAllTitleBasics();
		
		assertNotNull(resourceTitlesList);
		assertFalse(resourceTitlesList.isEmpty());
		assertEquals(responsesTitlesList, resourceTitlesList);
	}
	
	@Test
	@DisplayName("Should return empty titles list when genre is empty")
	void getAllTitleBasicsFilteredByGenreWithEmptyGenreWillReturnEmptyTitlesList() {
		final String genre = " ";
		final List<GetTitleBasicsResponse> resourceTitlesList = springTitleBasicsResource.getAllTitleBasicsFilteredByGenre(genre);
		assertNotNull(resourceTitlesList);
		assertTrue(resourceTitlesList.isEmpty());
	}
	
	@Test
	@DisplayName("Should return empty titles list when genre is null")
	void getAllTitleBasicsFilteredByGenreWithNullGenreWillReturnEmptyTitlesList() {
		final String genre = null;
		final List<GetTitleBasicsResponse> resourceTitlesList = springTitleBasicsResource.getAllTitleBasicsFilteredByGenre(genre);
		assertNotNull(resourceTitlesList);
		assertTrue(resourceTitlesList.isEmpty());
	}
	
	@Test
	@DisplayName("Should return empty titles list when genre is not found")
	void getAllTitleBasicsFilteredByGenreWithNotFoundGenreWillReturnEmptyTitlesList() {
		final String genre = "NOTFOUND";
		final List<GetTitleBasicsResponse> resourceTitlesList = springTitleBasicsResource.getAllTitleBasicsFilteredByGenre(genre);
		assertNotNull(resourceTitlesList);
		assertTrue(resourceTitlesList.isEmpty());
	}
	
	@Test
	@DisplayName("Should list all titles basics filtered by genre")
	void getAllTitleBasicsFilteredByGenreWithValidGenreWillSuccess() {
		final String genre = "Documentary";
		
		final GetTitleBasicsResponse responseTitle = new GetTitleBasicsResponse(
			"tt0000001","short","Carmencita","Carmencita",false,"1894","N",1,genre,"Short","N"
		);
		final List<GetTitleBasicsResponse> responsesTitlesList = new ArrayList<GetTitleBasicsResponse>();
		responsesTitlesList.add(responseTitle);
		responsesTitlesList.add(responseTitle);
		responsesTitlesList.add(responseTitle);
		
		when(titleBasicsController.getTitleBasicsFilteredByGenre(genre)).thenReturn(responsesTitlesList);
		
		final List<GetTitleBasicsResponse> resourceTitlesList = springTitleBasicsResource.getAllTitleBasicsFilteredByGenre(genre);
		
		assertNotNull(resourceTitlesList);
		assertFalse(resourceTitlesList.isEmpty());
		assertEquals(responsesTitlesList, resourceTitlesList);
	}

}
