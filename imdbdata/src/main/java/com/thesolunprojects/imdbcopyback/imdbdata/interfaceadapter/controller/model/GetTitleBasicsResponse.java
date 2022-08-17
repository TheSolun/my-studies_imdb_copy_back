package com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.controller.model;

public class GetTitleBasicsResponse {

	private String tconst;
	private String titleType;
	private String primaryTitle;
	private String originalTitle;
	private boolean isAdult;
	private String startYear;
	private String endYear;
	private String runtimeMinutes;
	private String genre1;
	private String genre2;
	private String genre3;
	
	public GetTitleBasicsResponse(String tconst, String titleType, String primaryTitle, String originalTitle, boolean isAdult,
			String startYear, String endYear, String runtimeMinutes, String genre1, String genre2, String genre3) {
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.originalTitle = originalTitle;
		this.isAdult = isAdult;
		this.startYear = startYear;
		this.endYear = endYear;
		this.runtimeMinutes = runtimeMinutes;
		this.genre1 = genre1;
		this.genre2 = genre2;
		this.genre3 = genre3;
	}

	public String getTconst() {
		return tconst;
	}

	public String getTitleType() {
		return titleType;
	}

	public String getPrimaryTitle() {
		return primaryTitle;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public boolean isAdult() {
		return isAdult;
	}

	public String getStartYear() {
		return startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public String getRuntimeMinutes() {
		return runtimeMinutes;
	}

	public String getGenre1() {
		return genre1;
	}

	public String getGenre2() {
		return genre2;
	}

	public String getGenre3() {
		return genre3;
	}
	
}
