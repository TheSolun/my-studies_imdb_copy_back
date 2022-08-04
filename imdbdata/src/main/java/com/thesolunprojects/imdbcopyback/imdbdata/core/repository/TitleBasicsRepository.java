package com.thesolunprojects.imdbcopyback.imdbdata.core.repository;

import java.util.List;

import com.thesolunprojects.imdbcopyback.imdbdata.core.entity.TitleBasicsEntity;

public interface TitleBasicsRepository {

	List<TitleBasicsEntity> findAll();

	List<TitleBasicsEntity> findByIsAdultStartYearAndGenre(boolean isAdult, String startYear, String genre);
	
}
