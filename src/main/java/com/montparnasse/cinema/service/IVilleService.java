package com.montparnasse.cinema.service;

import java.util.List;

import com.montparnasse.cinema.domaine.Cinema;
import com.montparnasse.cinema.domaine.Ville;

public interface IVilleService extends IService<Ville>{

	public List<Cinema> getCinemasVille(Long id);
	
	public Ville getByName(String name);
}
