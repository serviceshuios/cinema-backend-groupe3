package com.montparnasse.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.domaine.Ticket;
@Repository
@Transactional
public interface IProjectionDao extends JpaRepository<ProjectionFilm, Long> {
	
	@Query ("select p.tickets from ProjectionFilm p where p.id= :pId")
	public List<Ticket> getTicketsProjection(@Param ("pId") Long id);

} // fin interface
