package com.montparnasse.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montparnasse.cinema.dao.IPlaceDao;
import com.montparnasse.cinema.domaine.Place;

@Service
public class PlaceServiceImpl implements IPlaceService{
	
	@Autowired
	private IPlaceDao daoPlace;

	public IPlaceDao getDaoPlace() {
		return daoPlace;
	}

	public void setDaoPlace(IPlaceDao daoPlace) {
		this.daoPlace = daoPlace;
	}

	@Override
	public Place create(Place t) {
		return daoPlace.save(t);
		 
	}

	@Override
	public Place update(Place t) {
		return daoPlace.save(t);
		
	}

	@Override
	public boolean deleteById(Long id) {
		daoPlace.deleteById(id);
		return true;
	}

	@Override
	public Place getById(Long id) {
		return daoPlace.findById(id).get();
	}

	@Override
	public List<Place> getAll() {
		return daoPlace.findAll();
	}
}
