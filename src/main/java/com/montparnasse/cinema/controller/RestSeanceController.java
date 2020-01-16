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

import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.domaine.Seance;
import com.montparnasse.cinema.service.ISeanceService;

@CrossOrigin("*")
@RestController
public class RestSeanceController {

	@Autowired
	private ISeanceService service;

	// lister toutes les seances
	@RequestMapping(value = "/seances", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Seance> getAllSeances() {
		List<Seance> liste = service.getAll();
		return liste;
	} // fin getAll

	// récupérer une seance
	@RequestMapping(value = "/seances/{numSeance}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Seance getSeance(@PathVariable("numSeance") Long id) {
		return service.getById(id);
	}

	// récupérer la projection d'une seance
	@RequestMapping(value = "/seances/{numSeance}/projections", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<ProjectionFilm> getSeanceProjection(@PathVariable("numSeance") Long id) {
		return service.afficherProjectionSeance(id);
	}

	// ajouter une seance
	@RequestMapping(value = "/seances", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Seance ajouterSeance(@RequestBody Seance c) {
		return service.create(c);
	}

	// modifier une seance
	@RequestMapping(value = "/seances", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Seance modifierSeance(@RequestBody Seance c) {
		return service.update(c);
	}

	// supprimer une seance
	@RequestMapping(value = "/seances/{numSeance}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean deleteSeance(@PathVariable("numSeance") Long id) {
		return service.deleteById(id);
	}

} // fin classe
