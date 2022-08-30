package com.thesolunprojects.imdbcopyback.imdbdata.businessrule.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

@ExtendWith(MockitoExtension.class)
class GetAllTitleBasicsUCTest {

	@InjectMocks
	private GetAllTitleBasicsUC getAllTitleBasicsUC;
	
	@Mock
	TitleBasicsGateway titleGateway;
	
	@Test
	@DisplayName("Should list titles basics")
	void executeWillSuccess() {
		final TitleBasics title = new TitleBasics(
			"tt0000001","short","Carmencita","Carmencita",false,"1894","N",1,"Documentary","Short","N"
		);
		final List<TitleBasics> titlesList = new ArrayList<TitleBasics>();
		titlesList.add(title);
		titlesList.add(title);
		titlesList.add(title);
		
		when(titleGateway.getAllTitles()).thenReturn(titlesList);
		
		final List<TitleBasics> ucTitlesList = getAllTitleBasicsUC.execute();
		
		assertNotNull(ucTitlesList);
		assertFalse(ucTitlesList.isEmpty());
		assertEquals(titlesList, ucTitlesList);
	}

}
