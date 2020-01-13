package com.montparnasse.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.montparnasse.cinema.dao.IFilmDao;
import com.montparnasse.cinema.domaine.Film;

public class FilmServiceImpl implements IService<Film>{
	
	@Autowired
	private IFilmDao daoFilm;

	public IFilmDao getDaoPlace() {
		return daoFilm;
	}

	public void setDaoPlace(IFilmDao daoCategorie) {
		this.daoFilm = daoCategorie;
	}

	@Override
	public Film create(Film t) {
		return daoFilm.save(t);
		 
	}

	@Override
	public Film update(Film t) {
		return daoFilm.save(t);
		
	}

	@Override
	public boolean deleteById(Long id) {
		daoFilm.deleteById(id);
		return true;
	}

	@Override
	public Film getById(Long id) {
		return daoFilm.findById(id).get();
	}

	@Override
	public List<Film> getAll() {
		return daoFilm.findAll();
	}
}
