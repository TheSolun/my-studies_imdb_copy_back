package com.thesolunprojects.imdbcopyback.imdbdata.businessrule.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesolunprojects.imdbcopyback.imdbdata.businessrule.exception.GenreCanNotBeEmptyException;
import com.thesolunprojects.imdbcopyback.imdbdata.businessrule.exception.GenreCanNotBeNullException;
import com.thesolunprojects.imdbcopyback.imdbdata.domain.TitleBasics;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway.TitleBasicsGateway;

@Service
public class GetTitleBasicsByGenreUC {

	@Autowired
	private TitleBasicsGateway titleGateway;
	
	public List<TitleBasics> execute(String genre) {
		if(genre == null) {
			throw new GenreCanNotBeNullException();
		}
		if(genre.trim().length() == 0) {
			throw new GenreCanNotBeEmptyException();
		}
		return titleGateway.getTitlesFilteredByGenre(genre);
	}
	
}
