package com.thesolunprojects.imdbcopyback.imdbdata.domain;

public class TitleBasics {

	private String tconst;
	private String titleType;
	private String primaryTitle;
	private String originalTitle;
	private boolean isAdult;
	private String startYear;
	private String endYear;
	private Integer runtimeMinutes;
	private String genre1;
	private String genre2;
	private String genre3;
	
	public TitleBasics(String tconst, String titleType, String primaryTitle, String originalTitle, boolean isAdult,
			String startYear, String endYear, Integer runtimeMinutes, String genre1, String genre2, String genre3) {
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

	public Integer getRuntimeMinutes() {
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TitleBasics other = (TitleBasics) obj;
		if (endYear == null) {
			if (other.endYear != null)
				return false;
		} else if (!endYear.equals(other.endYear))
			return false;
		if (genre1 == null) {
			if (other.genre1 != null)
				return false;
		} else if (!genre1.equals(other.genre1))
			return false;
		if (genre2 == null) {
			if (other.genre2 != null)
				return false;
		} else if (!genre2.equals(other.genre2))
			return false;
		if (genre3 == null) {
			if (other.genre3 != null)
				return false;
		} else if (!genre3.equals(other.genre3))
			return false;
		if (isAdult != other.isAdult)
			return false;
		if (originalTitle == null) {
			if (other.originalTitle != null)
				return false;
		} else if (!originalTitle.equals(other.originalTitle))
			return false;
		if (primaryTitle == null) {
			if (other.primaryTitle != null)
				return false;
		} else if (!primaryTitle.equals(other.primaryTitle))
			return false;
		if (runtimeMinutes == null) {
			if (other.runtimeMinutes != null)
				return false;
		} else if (!runtimeMinutes.equals(other.runtimeMinutes))
			return false;
		if (startYear == null) {
			if (other.startYear != null)
				return false;
		} else if (!startYear.equals(other.startYear))
			return false;
		if (tconst == null) {
			if (other.tconst != null)
				return false;
		} else if (!tconst.equals(other.tconst))
			return false;
		if (titleType == null) {
			if (other.titleType != null)
				return false;
		} else if (!titleType.equals(other.titleType))
			return false;
		return true;
	}

}
