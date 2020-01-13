package com.montparnasse.cinema.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class ProjectionFilm implements Serializable{
	
	private SalleFilmId id;
	private Date dateProjection;
	private double prix;
	
	@OneToOne
	private Seance seance;
	
	@OneToMany(mappedBy = "projectionFilm")
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	
}
