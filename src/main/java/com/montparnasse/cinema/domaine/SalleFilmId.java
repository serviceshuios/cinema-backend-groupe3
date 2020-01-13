package com.montparnasse.cinema.domaine;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SalleFilmId implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="salleId")
	private Salle salle;
	@ManyToOne
	@JoinColumn(name="filmId")
	private Film film;
	
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	
}
