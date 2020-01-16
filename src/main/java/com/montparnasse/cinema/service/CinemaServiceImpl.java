package com.montparnasse.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montparnasse.cinema.dao.ICinemaDao;
import com.montparnasse.cinema.domaine.Cinema;
import com.montparnasse.cinema.domaine.Film;
import com.montparnasse.cinema.domaine.Salle;


@Service
public class CinemaServiceImpl implements ICinemaService{

	@Autowired
	private ICinemaDao daoCinema;

	public ICinemaDao getDaoCinema() {
		return daoCinema;
	}

	public void setDaoCinema(ICinemaDao daoCategorie) {
		this.daoCinema = daoCategorie;
	}

	@Override
	public Cinema create(Cinema t) {
		return daoCinema.save(t);
		 
	}

	@Override
	public Cinema update(Cinema t) {
		return daoCinema.save(t);
		
	}

	@Override
	public boolean deleteById(Long id) {
		daoCinema.deleteById(id);
		return true;
	}

	@Override
	public Cinema getById(Long id) {
		return daoCinema.findById(id).get();
	}

	@Override
	public List<Cinema> getAll() {
		return daoCinema.findAll();
	}
	
	@Override
	public List<Salle> getSallesCinema (Long id) {
		return daoCinema.getSallesCinema(id);
	}
	
	
}