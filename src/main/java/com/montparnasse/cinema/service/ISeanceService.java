package com.montparnasse.cinema.service;

import java.util.List;

import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.domaine.Seance;

public interface ISeanceService extends IService<Seance>{

	public List<ProjectionFilm> afficherProjectionSeance (Long id);
	
}
