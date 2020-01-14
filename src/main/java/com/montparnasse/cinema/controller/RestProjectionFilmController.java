package com.montparnasse.cinema.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.montparnasse.cinema.domaine.ProjectionFilm;
import com.montparnasse.cinema.domaine.SalleFilmId;
import com.montparnasse.cinema.service.IFilmService;
import com.montparnasse.cinema.service.IProjectionService;
import com.montparnasse.cinema.service.ISalleService;

@CrossOrigin("*")
@RestController
public class RestProjectionFilmController {

	@Autowired
	private IProjectionService service;
	
	@Autowired
	private IFilmService serviceFilm;
	
	@Autowired
	private ISalleService serviceSalle;
	
	// lister toutes les projections
	@RequestMapping (value = "/projections",
					method = RequestMethod.GET,
					produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<ProjectionFilm> getAllProjections() {
		List<ProjectionFilm> liste = service.getAll();
		return liste;
	} // fin getAll
	
	// récupérer une projection
	@RequestMapping(value = "/projections/{numSalle}/{numFilm}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ProjectionFilm getProjection(@PathVariable("numSalle") Long numSalle, @PathVariable("numFilm") Long numFilm) {
		//Création de la clé composée
		SalleFilmId sfid = new SalleFilmId();
		sfid.setFilm(serviceFilm.getById(numFilm));
		sfid.setSalle(serviceSalle.getById(numSalle));
		return service.getProjectionFilm(sfid);
    }
 
	// ajouter une projection
	@RequestMapping(value = "/projections/{numSalle}/{numFilm}/{prix}", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public ProjectionFilm ajouterProjection(@PathVariable("numSalle") Long numSalle, @PathVariable("numFilm") Long numFilm, @PathVariable("prix") Double prix) {
		//Création de la clé composée
		SalleFilmId sfid = new SalleFilmId();
		sfid.setFilm(serviceFilm.getById(numFilm));
		sfid.setSalle(serviceSalle.getById(numSalle));
		//Création de la projectionFilm
		ProjectionFilm projectionFilm = new ProjectionFilm();
		projectionFilm.setId(sfid);
		projectionFilm.setDateProjection(new Date());
		projectionFilm.setPrix(prix);
		//Ajout la filiereFormation
		return service.create(projectionFilm);
	}
	
	// modifier une projection
	@RequestMapping(value = "/projections/{numSalle}/{numFilm}/{numNouveauFilm}/{prix}", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public ProjectionFilm modifierProjection(@PathVariable("numSalle") Long numSalle, @PathVariable("numFilm") Long numFilm, @PathVariable("numNouveauFilm") Long numNouveauFilm, @PathVariable("prix") Double prix) {
		//Création de la clé composée
		SalleFilmId sfid = new SalleFilmId();
		sfid.setFilm(serviceFilm.getById(numFilm));
		sfid.setSalle(serviceSalle.getById(numSalle));
		//Récupération de la projectionFilm précédente
		ProjectionFilm projectionFilm = service.getProjectionFilm(sfid);
		//Suppression de la projection précédente par sa clé composée
		service.deleteProjectionFilm(sfid);
		//Mise à jour de la clé composée
		sfid.setFilm(serviceFilm.getById(numNouveauFilm));
		//Envoie de la mise à jour
		projectionFilm.setPrix(prix);
		return service.update(projectionFilm);
	}
	
	// supprimer une projection
	@RequestMapping(value = "/projections/{numSalle}/{numFilm}", //
			method = RequestMethod.DELETE, //
	        produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public boolean deleteProjection(@PathVariable("numSalle") Long numSalle, @PathVariable("numFilm") Long numFilm) {
		//Création de la clé composée
		SalleFilmId sfid = new SalleFilmId();
		sfid.setFilm(serviceFilm.getById(numFilm));
		sfid.setSalle(serviceSalle.getById(numSalle));
		return service.deleteProjectionFilm(sfid);
	 }
}
