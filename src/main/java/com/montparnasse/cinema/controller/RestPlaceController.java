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

import com.montparnasse.cinema.domaine.Place;
import com.montparnasse.cinema.service.IPlaceService;

@CrossOrigin("*")
@RestController
public class RestPlaceController {

	@Autowired
	private IPlaceService service;
	
	// lister tous les places
	@RequestMapping (value = "/places",
					method = RequestMethod.GET,
					produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Place> getAllPlaces() {
		List<Place> liste = service.getAll();
		return liste;
	} // fin getAll
	
	// récupérer une place
	@RequestMapping(value = "/places/{numPlace}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Place getPlace(@PathVariable("numPlace") Long id) {
		return service.getById(id);
    }
 
	// ajouter une place
	@RequestMapping(value = "/places", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public Place ajouterPlace(@RequestBody Place c) {
		return service.create(c);
	}
	
	// modifier une place
	@RequestMapping(value = "/places", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public Place modifierPlace(@RequestBody Place c) {
		return service.update(c);
	}
	
	// supprimer une place
		@RequestMapping(value = "/places/{numPlace}", //
	            method = RequestMethod.DELETE, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public boolean deletePlace(@PathVariable("numPlace") Long id) {
			return service.deleteById(id);
	    }
}
