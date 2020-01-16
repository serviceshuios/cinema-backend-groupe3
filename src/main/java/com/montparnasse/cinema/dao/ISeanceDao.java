package com.montparnasse.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montparnasse.cinema.domaine.ProjectionFilm;	
import com.montparnasse.cinema.domaine.Seance;
@Repository
@Transactional
public interface ISeanceDao extends JpaRepository<Seance, Long> {

	@Query("select s.projectionFilm FROM Seance s WHERE s.id= :pId")
	public ProjectionFilm getProjectionSeance (@Param("pId") Long id);
	
} // fin interface
