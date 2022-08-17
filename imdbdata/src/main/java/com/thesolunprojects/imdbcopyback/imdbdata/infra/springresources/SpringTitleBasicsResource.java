package com.thesolunprojects.imdbcopyback.imdbdata.infra.springresources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.controller.TitleBasicsController;
import com.thesolunprojects.imdbcopyback.imdbdata.interfaceadapter.controller.model.GetTitleBasicsResponse;

@RestController
@RequestMapping("/title-basics")
public class SpringTitleBasicsResource {

	@Autowired
	private TitleBasicsController titleBasicsController;

	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<GetTitleBasicsResponse> getAllTitleBasics() {
		return titleBasicsController.getAllTitleBasics();
	}
	
	@RequestMapping(value="/all/{genre}", method=RequestMethod.GET)
	public List<GetTitleBasicsResponse> getAllTitleBasicsFilteredByGenre(@PathVariable String genre) {
		return titleBasicsController.getTitleBasicsFilteredByGenre(genre);
	}
	
}
