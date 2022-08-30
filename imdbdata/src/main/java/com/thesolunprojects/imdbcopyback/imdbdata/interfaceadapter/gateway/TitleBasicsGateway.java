package com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesolunprojects.imdbcopyback.imdbdata.domain.TitleBasics;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway.repository.TitleBasicsRepository;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway.repository.model.TitleBasicsModel;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway.repository.model.TitleBasicsModelMapper;

@Service
public class TitleBasicsGateway {

	@Autowired
	private TitleBasicsRepository titleBasicsRepository;
	
	public List<TitleBasics> getAllTitles() {
		List<TitleBasics> titles = new ArrayList<TitleBasics>();
		for (TitleBasicsModel model : titleBasicsRepository.findAll()) {
			titles.add(TitleBasicsModelMapper.modelToEntity(model));
		}
		return titles;
	}
	
	public List<TitleBasics> getTitlesFilteredByGenre(String genre) {
		List<TitleBasics> titles = new ArrayList<TitleBasics>();
		for (TitleBasicsModel model : titleBasicsRepository.findByGenre(genre)) {
			titles.add(TitleBasicsModelMapper.modelToEntity(model));
		}
		return titles;
	}
	
}
