package com.montparnasse.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montparnasse.cinema.domaine.Salle;
@Repository
@Transactional
public interface ISalleDao extends JpaRepository<Salle, Long>{

} // fin interface
