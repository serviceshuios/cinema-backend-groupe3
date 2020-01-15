package com.montparnasse.cinema.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.service.IFilmService;
import com.montparnasse.cinema.service.IProjectionService;
import com.montparnasse.cinema.service.ISalleService;

@CrossOrigin("*")
@RestController
public class RestProjectionFilmController {

	@Autowired
	private IProjectionService service;
	
	
	// lister toutes les projections
	@RequestMapping (value = "/projections",
					method = RequestMethod.GET,
					produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<ProjectionFilm> getAllProjections() {
		List<ProjectionFilm> liste = service.getAll();
		return liste;
	} // fin getAll
	
	// récupérer une projection
	@RequestMapping(value = "/projections/{numProjection}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ProjectionFilm getProjection(@PathVariable("numProjection") Long numProjection) {
		return service.getById(numProjection);
    }
 

	@RequestMapping(value = "/projections/", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public ProjectionFilm ajouterProjection(@RequestBody ProjectionFilm projection) {

		return service.create(projection);
	}
	
	
	// modifier une projection
	@RequestMapping(value = "/projections/", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public ProjectionFilm modifierProjection(@RequestBody ProjectionFilm projection) {

		return service.update(projection);
	}
	
	// supprimer une projection
	@RequestMapping(value = "/projections/{idProjection}", //
			method = RequestMethod.DELETE, //
	        produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public boolean deleteProjection(@PathVariable("idProjection") Long idProjection) {

		return service.deleteById(idProjection);
	 }
}
