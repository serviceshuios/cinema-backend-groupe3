package com.montparnasse.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montparnasse.cinema.domaine.Cinema;
@Repository
@Transactional
public interface ICinemaDao extends JpaRepository<Cinema, Long> {

} // fin interface
