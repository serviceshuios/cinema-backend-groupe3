package com.montparnasse.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montparnasse.cinema.dao.IProjectionDao;
import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.domaine.SalleFilmId;

@Service
public class ProjectionServiceImpl implements IProjectionService{
	
	@Autowired
	private IProjectionDao daoProjection;

	public IProjectionDao getDaoProjection() {
		return daoProjection;
	}

	public void setDaoProjection(IProjectionDao daoProjection) {
		this.daoProjection = daoProjection;
	}

	@Override
	public ProjectionFilm create(ProjectionFilm t) {
		return daoProjection.save(t);
		 
	}

	@Override
	public ProjectionFilm update(ProjectionFilm t) {
		return daoProjection.save(t);
		
	}

	@Override
	public boolean deleteById(Long id) {
		return false;
	}

	@Override
	public ProjectionFilm getById(Long id) {
		return null;
	}

	@Override
	public List<ProjectionFilm> getAll() {
		return daoProjection.findAll();
	}

	@Override
	public ProjectionFilm getProjectionFilm(SalleFilmId id) {
		return daoProjection.findById(id).get();
	}

	@Override
	public boolean deleteProjectionFilm(SalleFilmId id) {
		daoProjection.deleteById(id);
		return true;
	}
	
}
