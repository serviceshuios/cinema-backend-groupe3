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

import com.montparnasse.cinema.domaine.Ville;
import com.montparnasse.cinema.service.IVilleService;

@CrossOrigin("*")
@RestController
public class RestVilleController {
	@Autowired
	private IVilleService service;

	// lister toutes les villes	
	@RequestMapping(value = "/villes", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Ville> getAllVilles() {
		List<Ville> liste = service.getAll();
		return liste;
	} // fin getAll

	// récupérer une ville
	@RequestMapping(value = "/villes/{numVille}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Ville getVille(@PathVariable("numVille") Long id) {
		return service.getById(id);
	}

	// ajouter une ville
	@RequestMapping(value = "/villes", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Ville ajouterVille(@RequestBody Ville ville) {
		return service.create(ville);
	}

	// modifier une ville
	@RequestMapping(value = "/villes", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Ville modifierVille(@RequestBody Ville ville) {
		return service.update(ville);
	}

	// supprimer une salle
	@RequestMapping(value = "/villes/{numVille}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean deleteVille(@PathVariable("numVille") Long id) {
		return service.deleteById(id);
	}

	
} // fin classe
