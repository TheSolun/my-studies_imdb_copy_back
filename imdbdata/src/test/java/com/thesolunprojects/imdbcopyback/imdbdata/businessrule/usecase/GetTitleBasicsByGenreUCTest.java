package com.thesolunprojects.imdbcopyback.imdbdata.businessrule.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
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
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.TitleBasicsGateway;

@ExtendWith(MockitoExtension.class)
class GetTitleBasicsByGenreUCTest {

	@InjectMocks
	private GetTitleBasicsByGenreUC getTitleBasicsByGenreUC;
	
	@Mock
	TitleBasicsGateway titleGateway;
	
	@Test
	@DisplayName("Should fail when genre is empty")
	void executeWithEmptyGenreWillFail() {
		final String genre = " ";
		
		IllegalArgumentException thrown = assertThrows(
			IllegalArgumentException.class, 
			() -> getTitleBasicsByGenreUC.execute(genre),
			"Expected should throw an Exception"
		);
		
		assertTrue(thrown.getMessage().contains("GENRE CAN NOT BE EMPTY"));
	}
	
	@Test
	@DisplayName("Should fail when genre is null")
	void executeWithNullGenreWillFail() {
		final String genre = null;
		
		IllegalArgumentException thrown = assertThrows(
			IllegalArgumentException.class, 
			() -> getTitleBasicsByGenreUC.execute(genre),
			"Expected should throw an Exception"
		);
		
		assertTrue(thrown.getMessage().contains("GENRE CAN NOT BE NULL"));
	}
	
	@Test
	@DisplayName("Should list titles basics when genre is valid")
	void executeWithValidGenreWillSuccess() {
		final TitleBasics title = new TitleBasics(
			"tt0000001","short","Carmencita","Carmencita",false,"1894","N",1,"Documentary","Short","N"
		);
		final List<TitleBasics> titlesList = new ArrayList<TitleBasics>();
		titlesList.add(title);
		titlesList.add(title);
		titlesList.add(title);
		
		when(titleGateway.getTitlesFilteredByGenre(anyString())).thenReturn(titlesList);
		
		final List<TitleBasics> ucTitlesList = getTitleBasicsByGenreUC.execute("Documentary");
		
		assertNotNull(ucTitlesList);
		assertFalse(ucTitlesList.isEmpty());
		assertEquals(titlesList, ucTitlesList);
		
	}

}
