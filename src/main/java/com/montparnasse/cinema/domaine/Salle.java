package com.montparnasse.cinema.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Salle", //
uniqueConstraints = { //
        @UniqueConstraint(name = "SALLE_UK", columnNames = "Salle_Name") })
public class Salle implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Salle_Id")
	private Long id;
	@Column(name = "Salle_Name", nullable = false)
	private String name;
	private int nombrePlaces;
	
	@JsonIgnore
	@ManyToOne
	private Cinema cinema;
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "salle")
	private List<Place> places;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "salle")
//	@JsonIgnore
	private List<ProjectionFilm> projectionFilm = new ArrayList<ProjectionFilm>();
	
	public Salle() {
		super();
	}
	public Salle(String name, int nombrePlaces) {
		super();
		this.name = name;
		this.nombrePlaces = nombrePlaces;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNombrePlaces() {
		return nombrePlaces;
	}
	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public List<Place> getPlaces() {
		return places;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	public List<ProjectionFilm> getProjectionFilm() {
		return projectionFilm;
	}
	public void setProjectionFilm(List<ProjectionFilm> projectionFilm) {
		this.projectionFilm = projectionFilm;
	}
	
}
