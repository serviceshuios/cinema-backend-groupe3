package com.montparnasse.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montparnasse.cinema.domaine.ProjectionFilm;
@Repository
@Transactional
public interface IProjectionDao extends JpaRepository<ProjectionFilm, Long> {

} // fin interface
