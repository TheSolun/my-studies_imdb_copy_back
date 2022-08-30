package com.thesolunprojects.imdbcopyback.imdbdata.businessrule.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesolunprojects.imdbcopyback.imdbdata.domain.TitleBasics;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.gateway.TitleBasicsGateway;

@Service
public class GetAllTitleBasicsUC {

	@Autowired
	private TitleBasicsGateway titleGateway;
	
	public List<TitleBasics> execute() {
		return this.titleGateway.getAllTitles();
	}
	
}
