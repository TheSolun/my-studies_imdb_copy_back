package com.thesolunprojects.imdbcopyback.imdbdata.businessrule.exception;

public class StartYearAndGenreCanNotBeNullException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StartYearAndGenreCanNotBeNullException() {
		super("START_YEAR_AND_GENRE_CAN_NOT_BE_NULL");
	}

}
