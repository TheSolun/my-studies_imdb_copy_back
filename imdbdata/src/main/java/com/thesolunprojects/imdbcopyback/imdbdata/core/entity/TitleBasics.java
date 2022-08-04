package com.thesolunprojects.imdbcopyback.imdbdata.core.entity;

public class TitleBasics {

	private String tconst;
	private String titleType;
	private String primaryTitle;
	private String originalTitle;
	private boolean isAdult;
	private String startYear;
	private String endYear;
	private String runtimeMinute;
	private String genre1;
	private String genre2;
	private String genre3;
	
	public TitleBasics(String tconst, String titleType, String primaryTitle, String originalTitle, boolean isAdult,
			String startYear, String endYear, String runtimeMinute, String genre1, String genre2, String genre3) {
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.originalTitle = originalTitle;
		this.isAdult = isAdult;
		this.startYear = startYear;
		this.endYear = endYear;
		this.runtimeMinute = runtimeMinute;
		this.genre1 = genre1;
		this.genre2 = genre2;
		this.genre3 = genre3;
	}

}
