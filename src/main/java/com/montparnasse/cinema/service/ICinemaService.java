package com.montparnasse.cinema.service;

import java.util.List;

import com.montparnasse.cinema.domaine.Cinema;
import com.montparnasse.cinema.domaine.Salle;

public interface ICinemaService extends IService<Cinema>{

	public List<Salle> getSallesCinema (Long id);
	
	
} // fin interface
