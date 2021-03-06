package com.montparnasse.cinema.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "Film", //
uniqueConstraints = { //
        @UniqueConstraint(name = "FILM_UK", columnNames = "Film_Titre") })
public class Film implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Film_Id")
	private Long id;
	@Column(name = "Film_titre", nullable = false)
	private String titre;
	private double duree;
	private String realisateur;
	private String description;
	private String photo;
	private Date dateSortie;
	
	@ManyToOne
	private Categorie categorie;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "film")
	@JsonIgnore
	private List<ProjectionFilm> projectionFilm = new ArrayList<ProjectionFilm>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	
	public List<ProjectionFilm> getProjectionFilm() {
		return projectionFilm;
	}

	public void setProjectionFilm(List<ProjectionFilm> projectionFilm) {
		this.projectionFilm = projectionFilm;
	}
	
	
	
}
