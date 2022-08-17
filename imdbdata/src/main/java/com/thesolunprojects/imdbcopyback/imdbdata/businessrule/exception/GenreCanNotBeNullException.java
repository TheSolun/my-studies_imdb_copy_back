package com.thesolunprojects.imdbcopyback.imdbdata.businessrule.exception;

public class GenreCanNotBeNullException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GenreCanNotBeNullException() {
		super("GENRE CAN NOT BE NULL");
	}

}
