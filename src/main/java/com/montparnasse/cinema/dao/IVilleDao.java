package com.montparnasse.cinema.dao;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montparnasse.cinema.domaine.Cinema;
import com.montparnasse.cinema.domaine.Ville;
@Repository
@Transactional
public interface IVilleDao extends JpaRepository<Ville, Long>{

	@Query("select v.cinemas from Ville v where v.id= :pid")
	public List<Cinema> getCinemasVille(@Param("pid")Long id);
	
	public Ville getByName(String name);
} // fin interface
