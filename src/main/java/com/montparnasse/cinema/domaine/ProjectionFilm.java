package com.montparnasse.cinema.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProjectionFilm implements Serializable{
	
	@EmbeddedId
	private SalleFilmId id;
	private Date dateProjection;
	private double prix;
	
	@OneToOne
	@JsonIgnore
	private Seance seance;
	
	@OneToMany(mappedBy = "projectionFilm")
	@JsonIgnore
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	public SalleFilmId getId() {
		return id;
	}

	public void setId(SalleFilmId id) {
		this.id = id;
	}

	public Date getDateProjection() {
		return dateProjection;
	}

	public void setDateProjection(Date dateProjection) {
		this.dateProjection = dateProjection;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
}
