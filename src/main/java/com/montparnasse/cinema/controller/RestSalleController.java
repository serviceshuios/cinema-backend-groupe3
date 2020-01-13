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
import com.montparnasse.cinema.domaine.Salle;
import com.montparnasse.cinema.service.ISalleService;

@CrossOrigin("*")
@RestController
public class RestSalleController {

	@Autowired
	private ISalleService service;

	// lister tous les salles
	@RequestMapping(value = "/salles", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Salle> getAllSalles() {
		List<Salle> liste = service.getAll();
		return liste;
	} // fin getAll

	// récupérer une salle
	@RequestMapping(value = "/salles/{numSalle}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Salle getSalle(@PathVariable("numSalle") Long id) {
		return service.getById(id);
	}

	// ajouter une salle
	@RequestMapping(value = "/salles", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Salle ajouterSalle(@RequestBody Salle salle) {
		return service.create(salle);
	}

	// modifier une salle
	@RequestMapping(value = "/salles", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Salle modifierSalle(@RequestBody Salle sal) {
		return service.update(sal);
	}

	// supprimer une salle
	@RequestMapping(value = "/salles/{numSalle}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean deleteSalle(@PathVariable("numSalle") Long id) {
		return service.deleteById(id);
	}

} // fin classe
