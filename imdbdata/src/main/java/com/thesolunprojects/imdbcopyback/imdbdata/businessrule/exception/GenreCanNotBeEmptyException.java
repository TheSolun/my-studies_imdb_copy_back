package com.thesolunprojects.imdbcopyback.imdbdata.businessrule.exception;

public class GenreCanNotBeEmptyException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GenreCanNotBeEmptyException() {
		super("GENRE CAN NOT BE EMPTY");
	}

}
