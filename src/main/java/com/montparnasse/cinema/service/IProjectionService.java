package com.montparnasse.cinema.service;

import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.domaine.SalleFilmId;

public interface IProjectionService extends IService<ProjectionFilm>{

	public ProjectionFilm getProjectionFilm(SalleFilmId id);
	
	public boolean deleteProjectionFilm(SalleFilmId id);
	
}
