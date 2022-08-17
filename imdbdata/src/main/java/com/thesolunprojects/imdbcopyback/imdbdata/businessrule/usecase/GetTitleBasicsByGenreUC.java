package com.thesolunprojects.imdbcopyback.imdbdata.businessrule.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesolunprojects.imdbcopyback.imdbdata.domain.TitleBasics;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.TitleBasicsGateway;

@Service
public class GetTitleBasicsByGenreUC {

	@Autowired
	private TitleBasicsGateway titleGateway;
	
	public List<TitleBasics> execute(String genre) {
		return titleGateway.getTitlesFilteredByGenre(genre);
	}
	
}
