package com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.controller.model;

import com.thesolunprojects.imdbcopyback.imdbdata.domain.TitleBasics;

public abstract class GetTitleBasicsResponseMapper {

	public static GetTitleBasicsResponse entityToResponse(TitleBasics entity) {
		return new GetTitleBasicsResponse(
				entity.getTconst(), 
				entity.getTitleType(), 
				entity.getPrimaryTitle(), 
				entity.getOriginalTitle(), 
				entity.isAdult(), 
				entity.getStartYear(), 
				entity.getEndYear(), 
				entity.getRuntimeMinutes(), 
				entity.getGenre1(), 
				entity.getGenre2(), 
				entity.getGenre3()
		);
	}
	
}
