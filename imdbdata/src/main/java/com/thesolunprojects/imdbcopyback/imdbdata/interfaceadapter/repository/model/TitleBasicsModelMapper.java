package com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.repository.model;

import com.thesolunprojects.imdbcopyback.imdbdata.domain.TitleBasics;

public abstract class TitleBasicsModelMapper {

	public static TitleBasics modelToEntity(TitleBasicsModel model) {
		return new TitleBasics(
			model.getTconst(), 
			model.getTitleType(), 
			model.getPrimaryTitle(),
			model.getOriginalTitle(),
			model.isAdult() == 1,
			model.getStartYear(),
			model.getEndYear(),
			model.getRuntimeMinutes(),
			model.getGenre1(),
			model.getGenre2(),
			model.getGenre3()
		);
	}
	
}
