package com.montparnasse.cinema.domaine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cinema implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double longitude;
	private double latitude;
	private double altitude;
	private int nombreSalles;
	
	/*----------association-----------*/  
	@ManyToOne
	private Ville ville;
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "cinema")
	List<Salle> salles;
	
	/*------constructeur vide----*/
	public Cinema() {}
	
	/*-----------constructeur-----*/

	public Cinema(String name, double longitude, double latitude, double altitude, int nombreSalles) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
		this.nombreSalles = nombreSalles;
	}

	/*---------getter/setter---------------*/
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
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public int getNombreSalles() {
		return nombreSalles;
	}
	public void setNombreSalles(int nombreSalles) {
		this.nombreSalles = nombreSalles;
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}
	
	

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	/*-------------------toString-----------*/
	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", altitude=" + altitude + ", nombreSalles=" + nombreSalles + "]";
	}
	
	
	
	
} // fin classe
