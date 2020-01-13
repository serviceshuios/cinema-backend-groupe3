package com.montparnasse.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montparnasse.cinema.domaine.Seance;
@Repository
@Transactional
public interface ISeanceDao extends JpaRepository<Seance, Long> {

	
} // fin interface
