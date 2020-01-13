package com.montparnasse.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.montparnasse.cinema.domaine.Categorie;

@RestController
public class RestCategorieController {
	@Autowired
	private IService service;
	
	public List<Categorie> getAllCategories() {
		List<Categorie> liste = service.findAll();
	} // fin getAll
	
	
	
	
} // fin classe
