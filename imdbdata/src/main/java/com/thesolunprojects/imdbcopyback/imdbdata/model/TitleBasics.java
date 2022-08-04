package com.thesolunprojects.imdbcopyback.imdbdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "title_basics")
public class TitleBasics {
        
        @Id
        @Column(name="tconst")
        private String tconst;
        
        @Column(name="primaryTitle")
        private String primaryTitle;
        
        @Column(name="originalTitle")
        private String originalTitle;
        
        @Column(name="isAdult")
        private boolean isAdult;
        
        @Column(name="startYear")
        private String startYear;
        
        @Column(name="endYear")
        private String endYear;
        
        @Column(name="runtimeMinutes")
        private String runtimeMinutes;
        
        @Column(name="genre1")
        private String genre1;
        
        @Column(name="genre2")
        private String genre2;
        
        @Column(name="genre3")
        private String genre3;
}
