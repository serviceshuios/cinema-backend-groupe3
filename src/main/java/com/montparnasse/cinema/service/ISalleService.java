package com.montparnasse.cinema.service;

import com.montparnasse.cinema.domaine.Salle;

public interface ISalleService extends IService<Salle>{
	
	public Salle getByName(String name);
}
