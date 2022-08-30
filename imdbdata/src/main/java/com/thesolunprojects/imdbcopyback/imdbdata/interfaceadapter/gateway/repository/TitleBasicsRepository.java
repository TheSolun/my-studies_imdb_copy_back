package com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway.repository.model.TitleBasicsModel;

@Repository
public interface TitleBasicsRepository extends JpaRepository<TitleBasicsModel, String> {
	
	@Query("SELECT t FROM title_basics t WHERE (t.genre1 = :genre OR t.genre2 = :genre OR t.genre3 = :genre)")
	List<TitleBasicsModel> findByGenre(String genre);
	
	@Query("SELECT t FROM title_basics t")
	List<TitleBasicsModel> findAll();
	
}
