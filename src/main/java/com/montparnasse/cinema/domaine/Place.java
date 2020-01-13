package com.montparnasse.cinema.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	private double longitude;
	private double latitude;
	private double altidude;
	
	public Place() {
		super();
	}
	public Place(int numero, double longitude, double latitude, double altidude) {
		super();
		this.numero = numero;
		this.longitude = longitude;
		this.latitude = latitude;
		this.altidude = altidude;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	public double getAltidude() {
		return altidude;
	}
	public void setAltidude(double altidude) {
		this.altidude = altidude;
	}
	@Override
	public String toString() {
		return "Place [id=" + id + ", numero=" + numero + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", altidude=" + altidude + "]";
	}
	
	
}