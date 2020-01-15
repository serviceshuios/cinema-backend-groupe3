package com.montparnasse.cinema.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ProjectionFilm", //
uniqueConstraints = { //
		 @UniqueConstraint(name = "FILM_SALLE_UK", columnNames = { "Film_Id", "Salle_Id" }) })
public class ProjectionFilm implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Long id;
	private Date dateProjection;
	private double prix;
	
	@ManyToOne
    @JoinColumn(name = "Film_Id", nullable = false)
    private Film film;
 
    @ManyToOne
    @JoinColumn(name = "Salle_Id", nullable = false)
    private Salle salle;
	
	@OneToOne
//	@JsonIgnore
	private Seance seance;
	
	@OneToMany(mappedBy = "projectionFilm")
//	@JsonIgnore
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	
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
