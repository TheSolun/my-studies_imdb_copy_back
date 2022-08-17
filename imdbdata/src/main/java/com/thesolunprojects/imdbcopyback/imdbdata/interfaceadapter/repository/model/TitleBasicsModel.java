package com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "title_basics")
@Table(name = "title_basics")
public class TitleBasicsModel {
        
        @Id
        @Column(name="tconst")
        private String tconst;
        
        @Column(name="title_type")
        private String title_type;
        
        @Column(name="primary_title")
        private String primary_title;
        
        @Column(name="original_title")
        private String original_title;
        
        @Column(name="is_adult")
        private int is_adult;
        
        @Column(name="start_year")
        private String start_year;
        
        @Column(name="end_year")
        private String end_year;
        
        @Column(name="runtime_minutes")
        private String runtime_minutes;
        
        @Column(name="genre1")
        private String genre1;
        
        @Column(name="genre2")
        private String genre2;
        
        @Column(name="genre3")
        private String genre3;
        
        public TitleBasicsModel() {}
        
		public TitleBasicsModel(String tconst, String title_type, String primary_title, String original_title,
				int is_adult, String start_year, String end_year, String runtime_minutes, String genre1, String genre2,
				String genre3) {
			this.tconst = tconst;
			this.title_type = title_type;
			this.primary_title = primary_title;
			this.original_title = original_title;
			this.is_adult = is_adult;
			this.start_year = start_year;
			this.end_year = end_year;
			this.runtime_minutes = runtime_minutes;
			this.genre1 = genre1;
			this.genre2 = genre2;
			this.genre3 = genre3;
		}

		public String getEndYear() {
			return end_year;
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

		public String getOriginalTitle() {
			return original_title;
		}

		public String getPrimaryTitle() {
			return primary_title;
		}

		public String getRuntimeMinutes() {
			return runtime_minutes;
		}

		public String getStartYear() {
			return start_year;
		}

		public String getTconst() {
			return tconst;
		}

		public String getTitleType() {
			return title_type;
		}

		public int isAdult() {
			return is_adult;
		}
       
}
