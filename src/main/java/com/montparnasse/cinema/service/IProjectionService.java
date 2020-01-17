package com.montparnasse.cinema.service;

import java.util.List;

import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.domaine.Ticket;

public interface IProjectionService extends IService<ProjectionFilm>{
	
	public List<Ticket> getTicketsProjection(Long id);

}
