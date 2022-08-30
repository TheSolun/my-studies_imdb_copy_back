package com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway.repository.model;

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
			(model.getEndYear().length() >= 1 && model.getEndYear().charAt(0) != 'N')
				? model.getEndYear()
				: null,
			(model.getRuntimeMinutes().length() >= 1 && model.getRuntimeMinutes().charAt(0) != 'N')
				? Integer.parseInt(model.getRuntimeMinutes()) 
				: null,
			(model.getGenre1().length() >= 1 && model.getGenre1().charAt(0) != 'N')
				? model.getGenre1() 
				: null,
			(model.getGenre2().length() >= 1 && model.getGenre2().charAt(0) != 'N')
				? model.getGenre2() 
				: null,
			(model.getGenre3().length() >= 1 && model.getGenre3().charAt(0) != 'N')
				? model.getGenre3() 
				: null
		);
	}
	
}
