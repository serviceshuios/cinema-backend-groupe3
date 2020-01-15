package com.montparnasse.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montparnasse.cinema.domaine.Film;
@Repository
@Transactional
public interface IFilmDao extends JpaRepository<Film, Long>{
	
	public Film getByTitre(String name);

} // fin interface 
