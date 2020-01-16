package com.montparnasse.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montparnasse.cinema.domaine.Cinema;
import com.montparnasse.cinema.domaine.Salle;
@Repository
@Transactional
public interface ICinemaDao extends JpaRepository<Cinema, Long> {
	
	@Query("select c.salles FROM Cinema c WHERE c.id= :pId")
	public List<Salle> getSallesCinema (@Param("pId") Long id);

} // fin interface
