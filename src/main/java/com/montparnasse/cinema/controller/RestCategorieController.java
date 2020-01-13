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

import com.montparnasse.cinema.domaine.Categorie;
import com.montparnasse.cinema.service.ICategorieService;

@CrossOrigin("*")
@RestController
public class RestCategorieController {
	@Autowired
	private ICategorieService service;
	
	// lister tous les categories
	@RequestMapping (value = "/categories",
					method = RequestMethod.GET,
					produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Categorie> getAllCategories() {
		List<Categorie> liste = service.getAll();
		return liste;
	} // fin getAll
	
	// récupérer une categorie
	@RequestMapping(value = "/categories/{numCategorie}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Categorie getCategorie(@PathVariable("numCategorie") Long id) {
		return service.getById(id);
    }
 
	// ajouter une categorie
	@RequestMapping(value = "/categories", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public Categorie ajouterCategorie(@RequestBody Categorie c) {
		return service.create(c);
	}
	
	// modifier une categorie
	@RequestMapping(value = "/categories", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public Categorie modifierCategorie(@RequestBody Categorie c) {
		return service.update(c);
	}
	
	// supprimer une categorie
		@RequestMapping(value = "/categories/{numCategorie}", //
	            method = RequestMethod.DELETE, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public boolean deleteCategorie(@PathVariable("numCategorie") Long id) {
			return service.deleteById(id);
	    }
		

	
} // fin classe
