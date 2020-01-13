package com.montparnasse.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.montparnasse.cinema.dao.IVilleDao;
import com.montparnasse.cinema.domaine.Ville;

public class VilleServiceImpl implements IService<Ville>{
	
	@Autowired
	private IVilleDao daoVille;
	
	public IVilleDao getDaoVille() {
		return daoVille;
	}

	public void setDaoVille(IVilleDao daoVille) {
		this.daoVille = daoVille;
	}

	@Override
	public Ville create(Ville t) {
		return daoVille.save(t);
	}

	@Override
	public Ville update(Ville t) {
		return daoVille.save(t);
	}

	@Override
	public boolean deleteById(Long id) {
		daoVille.deleteById(id);
		return false;
	}

	@Override
	public Ville getById(Long id) {
		return daoVille.findById(id).get();
	}

	@Override
	public List<Ville> getAll() {
		return daoVille.findAll();
	}
	
}
