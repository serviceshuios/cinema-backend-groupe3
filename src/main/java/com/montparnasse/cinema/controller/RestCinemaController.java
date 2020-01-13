package com.montparnasse.cinema.controller;

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


import com.montparnasse.cinema.domaine.Cinema;
import com.montparnasse.cinema.service.ICinemaService;

@CrossOrigin("*")
@RestController
public class RestCinemaController {

	@Autowired
	private ICinemaService service;
	
	// lister tous les cinemas
	@RequestMapping (value = "/cinemas",
					method = RequestMethod.GET,
					produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Cinema> getAllCinemas() {
		List<Cinema> liste = service.getAll();
		return liste;
	} // fin getAll
	
	// récupérer un cinema
	@RequestMapping(value = "/cinemas/{numCinema}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Cinema getCinema(@PathVariable("numCinema") Long id) {
		return service.getById(id);
    }
 
	// ajouter un cinema
	@RequestMapping(value = "/cinemas", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public Cinema ajouterCinema(@RequestBody Cinema c) {
		return service.create(c);
	}
	
	// modifier un cinema
	@RequestMapping(value = "/cinemas", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public Cinema modifierCinema(@RequestBody Cinema c) {
		return service.update(c);
	}
	
	// supprimer un cinema
		@RequestMapping(value = "/cinemas/{numCinema}", //
	            method = RequestMethod.DELETE, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public boolean deleteCinema(@PathVariable("numCinema") Long id) {
			return service.deleteById(id);
	    }
		

	
} // fin classe 
