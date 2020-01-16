package com.montparnasse.cinema.service;

import java.util.List;

import com.montparnasse.cinema.domaine.Place;
import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.domaine.Salle;

public interface ISalleService extends IService<Salle>{
	
	public Salle getByName(String name);
	
	public List<Place> getPlacesSalle (Long id);
	
	public List<ProjectionFilm> getProjectionsSalle (Long id);
	
}
