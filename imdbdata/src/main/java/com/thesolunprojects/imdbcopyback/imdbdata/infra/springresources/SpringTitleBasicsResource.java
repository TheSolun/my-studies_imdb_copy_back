package com.thesolunprojects.imdbcopyback.imdbdata.infra.springresources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.thesolunprojects.imdbcopyback.imdbdata.businessrule.exception.GenreCanNotBeEmptyException;
import com.thesolunprojects.imdbcopyback.imdbdata.businessrule.exception.GenreCanNotBeNullException;
import com.thesolunprojects.imdbcopyback.imdbdata.businessrule.exception.TitleBasicsNotFoundException;
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
	
	@ExceptionHandler({TitleBasicsNotFoundException.class})
	public ResponseEntity<String> handleTitleBasicsNotFoundException(TitleBasicsNotFoundException ex) {
		HttpStatus status = HttpStatus.BAD_GATEWAY;
		if(ex.getMessage() == (new GenreCanNotBeEmptyException()).getMessage() 
				|| ex.getMessage() == (new GenreCanNotBeNullException()).getMessage()) {
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity
				.status(status)
				.body("{\n\t\"Error\": \""+ex.getMessage()+"\"\n}");
	}
	
	@ExceptionHandler({InternalServerError.class})
    public ResponseEntity<String> handleInternalServerErrorException(InternalServerError ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("{\n\t\"Error\": \"Internal Server Error\"\n}");
    }
	
}
