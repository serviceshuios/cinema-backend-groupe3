package com.montparnasse.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.service.IProjectionService;

@RestController
public class RestProjectionFilmController {

	@Autowired
	private IProjectionService service;
	
	// lister tous les projections
	@RequestMapping (value = "/projections",
					method = RequestMethod.GET,
					produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<ProjectionFilm> getAllProjections() {
		List<ProjectionFilm> liste = service.getAll();
		return liste;
	} // fin getAll
	
	// récupérer une place
	@RequestMapping(value = "/projections/{numProjection}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ProjectionFilm getProjection(@PathVariable("numProjection") Long id) {
		return service.getById(id);
    }
 
	// ajouter une place
	@RequestMapping(value = "/projections", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public ProjectionFilm ajouterProjection(@RequestBody ProjectionFilm c) {
		return service.create(c);
	}
	
	// modifier une place
	@RequestMapping(value = "/projections", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public ProjectionFilm modifierProjection(@RequestBody ProjectionFilm c) {
		return service.update(c);
	}
	
	// supprimer une place
		@RequestMapping(value = "/projections/{numProjection}", //
	            method = RequestMethod.DELETE, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public boolean deleteProjection(@PathVariable("numProjection") Long id) {
			return service.deleteById(id);
	    }
}
