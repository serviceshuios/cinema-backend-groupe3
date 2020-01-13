package com.montparnasse.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.montparnasse.cinema.domaine.Place;
@Repository
@Transactional
public interface IPlaceDao extends JpaRepository<Place, Long>{

} // fin interface
