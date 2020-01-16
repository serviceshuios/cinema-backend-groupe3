package com.montparnasse.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montparnasse.cinema.dao.ISeanceDao;
import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.domaine.Seance;

@Service
public class SeanceServiceImpl implements ISeanceService{

	@Autowired
	private ISeanceDao daoSeance; 

	public ISeanceDao getDaoSeance() {
		return daoSeance;
	}

	public void setDaoSeance(ISeanceDao daoSeance) {
		this.daoSeance = daoSeance;
	}

	@Override
	public Seance create(Seance t) {
		return daoSeance.save(t);
		 
	}

	@Override
	public Seance update(Seance t) {
		return daoSeance.save(t);
		
	}

	@Override
	public boolean deleteById(Long id) {
		daoSeance.deleteById(id);
		return true;
	}

	@Override
	public Seance getById(Long id) {
		return daoSeance.findById(id).get();
	}

	@Override
	public List<Seance> getAll() {
		return daoSeance.findAll();
	}

	@Override
	public List<ProjectionFilm> afficherProjectionSeance(Long id) {
		return daoSeance.getProjectionSeance(id);
	}
}
