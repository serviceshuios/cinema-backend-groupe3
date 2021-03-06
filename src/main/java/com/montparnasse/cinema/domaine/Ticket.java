package com.montparnasse.cinema.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ticket implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomClient;
	private double prix;
	private int codePayement;
	private boolean reservee;
	
	@ManyToOne
	private ProjectionFilm projectionFilm;
	

	@ManyToOne
	private Place place;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getCodePayement() {
		return codePayement;
	}
	public void setCodePayement(int codePayement) {
		this.codePayement = codePayement;
	}
	public boolean isReservee() {
		return reservee;
	}
	public void setReservee(boolean reservee) {
		this.reservee = reservee;
	}
	public ProjectionFilm getProjectionFilm() {
		return projectionFilm;
	}
	public void setProjectionFilm(ProjectionFilm projectionFilm) {
		this.projectionFilm = projectionFilm;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	
	
}
