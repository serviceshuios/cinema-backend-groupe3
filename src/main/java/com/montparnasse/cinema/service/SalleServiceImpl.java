package com.montparnasse.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montparnasse.cinema.dao.ISalleDao;
import com.montparnasse.cinema.domaine.Place;
import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.domaine.Salle;

@Service
public class SalleServiceImpl implements ISalleService{
	
	@Autowired
	private ISalleDao daoSalle;

	public ISalleDao getDaoSalle() {
		return daoSalle;
	}

	public void setDaoSalle(ISalleDao daoSalle) {
		this.daoSalle = daoSalle;
	}

	@Override
	public Salle create(Salle t) {
		return daoSalle.save(t);
		 
	}

	@Override
	public Salle update(Salle t) {
		return daoSalle.save(t);
		
	}

	@Override
	public boolean deleteById(Long id) {
		daoSalle.deleteById(id);
		return true;
	}

	@Override
	public Salle getById(Long id) {
		return daoSalle.findById(id).get();
	}

	@Override
	public List<Salle> getAll() {
		return daoSalle.findAll();
	}

	@Override
	public Salle getByName(String name) {
		return daoSalle.getByName(name);
	}

	@Override
	public List<Place> getPlacesSalle(Long id) {
		return daoSalle.getPlacesSalle(id);
	}

	@Override
	public List<ProjectionFilm> getProjectionsSalle(Long id) {

		return daoSalle.getProjectionsSalle(id);
	}
}
