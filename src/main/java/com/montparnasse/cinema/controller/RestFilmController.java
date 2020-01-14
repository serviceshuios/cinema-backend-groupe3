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

import com.montparnasse.cinema.domaine.Film;
import com.montparnasse.cinema.service.IFilmService;

@CrossOrigin("*")
@RestController
public class RestFilmController {

	@Autowired
	private IFilmService service;
	
	// lister tous les films
	@RequestMapping (value = "/films",
					method = RequestMethod.GET,
					produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Film> getAllFilms() {
		List<Film> liste = service.getAll();
		return liste;
	} // fin getAll
	
	// récupérer un films
	@RequestMapping(value = "/films/{numFilm}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Film getFilm(@PathVariable("numFilm") Long id) {
		return service.getById(id);
    }
 
	// ajouter un films
	@RequestMapping(value = "/films", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public Film ajouterFilm(@RequestBody Film f) {
		return service.create(f);
	}
	
	// modifier un films
	@RequestMapping(value = "/films", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public Film modifierFilm(@RequestBody Film f) {
		return service.update(f);
	}
	
	// supprimer un films
		@RequestMapping(value = "/films/{numFilm}", //
	            method = RequestMethod.DELETE, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public boolean deleteFilm(@PathVariable("numFilm") Long id) {
			return service.deleteById(id);
	    }
		

	
	
} // fin classe
