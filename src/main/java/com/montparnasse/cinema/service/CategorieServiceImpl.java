
package com.montparnasse.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montparnasse.cinema.dao.ICategorieDao;
import com.montparnasse.cinema.domaine.Categorie;

@Service
public class CategorieServiceImpl implements IService<Categorie>{

	@Autowired
	private ICategorieDao daoCategorie;

	public ICategorieDao getDaoCategorie() {
		return daoCategorie;
	}

	public void setDaoCategorie(ICategorieDao daoCategorie) {
		this.daoCategorie = daoCategorie;
	}

	@Override
	public Categorie create(Categorie t) {
		return daoCategorie.save(t);
		 
	}

	@Override
	public Categorie update(Categorie t) {
		return daoCategorie.save(t);
		
	}

	@Override
	public boolean deleteById(Long id) {
		daoCategorie.deleteById(id);
		return true;
	}

	@Override
	public Categorie getById(Long id) {
		return daoCategorie.findById(id).get();
	}

	@Override
	public List<Categorie> getAll() {
		return daoCategorie.findAll();
	}
	
}