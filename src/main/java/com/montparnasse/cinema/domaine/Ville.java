package com.montparnasse.cinema.domaine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ville implements Serializable{

	/* Propriétés */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double longitude;
	private double latitude;
	private double altitude;
	
	@OneToMany(mappedBy = "ville")
	@JsonIgnore
	private List<Cinema> cinemas;
	
	/* Constructeurs */
	public Ville() {}

	public Ville(String name, double longitude, double latitude, double altitude) {
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altitude = altitude;
	}
	
	/* Getters-Setter */
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

	
	
	public List<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

	/* To String */
	@Override
	public String toString() {
		return "Ville [id=" + id + ", name=" + name + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", altitude=" + altitude + "]";
	}
	
}//End class
