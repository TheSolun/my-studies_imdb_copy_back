package com.thesolunprojects.imdbcopyback.imdbdata.core.usecase;

import java.util.List;

import com.thesolunprojects.imdbcopyback.imdbdata.core.entity.TitleEntity;
import com.thesolunprojects.imdbcopyback.imdbdata.core.repository.TitleRepository;

public class GetAllTitles {

	private TitleRepository titleRepository;

	public GetAllTitles(TitleRepository titleRepository) {
		this.titleRepository = titleRepository;
	}
	
	public List<TitleEntity> execute() {
		return this.titleRepository.findAll();
	}
	
}
