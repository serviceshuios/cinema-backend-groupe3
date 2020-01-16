package com.montparnasse.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montparnasse.cinema.domaine.Place;
import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.domaine.Salle;
@Repository
@Transactional
public interface ISalleDao extends JpaRepository<Salle, Long>{
	
	
	public Salle getByName(String name);
	
	@Query ("SELECT s.places FROM Salle s WHERE s.id= :pId")
	public List<Place> getPlacesSalle (@Param("pId") Long id);
	
	@Query ("SELECT s.projectionFilm FROM Salle s WHERE s.id= :pId")
	public List<ProjectionFilm> getProjectionsSalle (@Param("pId") Long id);

} // fin interface
