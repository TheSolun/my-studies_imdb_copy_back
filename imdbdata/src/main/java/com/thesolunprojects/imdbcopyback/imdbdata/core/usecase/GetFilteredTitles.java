package com.thesolunprojects.imdbcopyback.imdbdata.core.usecase;

import java.util.List;

import com.thesolunprojects.imdbcopyback.imdbdata.core.entity.TitleEntity;
import com.thesolunprojects.imdbcopyback.imdbdata.core.repository.TitleRepository;

public class GetFilteredTitles {

	private TitleRepository titleRepository;
	
	public List<TitleEntity> execute(boolean isAdult, String startYear, String genre) {
		return titleRepository.findByIsAdultStartYearAndGenre(isAdult, startYear, genre);
	}
	
}
