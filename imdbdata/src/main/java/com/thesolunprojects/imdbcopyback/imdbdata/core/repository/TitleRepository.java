package com.thesolunprojects.imdbcopyback.imdbdata.core.repository;

import java.util.List;

import com.thesolunprojects.imdbcopyback.imdbdata.core.entity.TitleEntity;

public interface TitleRepository {

	List<TitleEntity> findAll();

	List<TitleEntity> findByIsAdultStartYearAndGenre(boolean isAdult, String startYear, String genre);
	
}
