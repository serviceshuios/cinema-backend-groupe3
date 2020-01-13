package com.montparnasse.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.montparnasse.cinema.domaine.Ticket;
import com.montparnasse.cinema.service.ITicketService;

@CrossOrigin("*")
@RestController
public class RestTicketController {
	
	@Autowired
	private ITicketService service;
	
	// lister tous les tickets
	@RequestMapping (value = "/tickets",
					method = RequestMethod.GET,
					produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Ticket> getAllTickets() {
		List<Ticket> liste = service.getAll();
		return liste;
	} // fin getAll
	
	// récupérer un ticket
	@RequestMapping(value = "/tickets/{numTicket}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Ticket getTicket(@PathVariable("numTicket") Long id) {
		return service.getById(id);
    }
 
	// ajouter un ticket
	@RequestMapping(value = "/tickets", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public Ticket ajouterTicket(@RequestBody Ticket c) {
		return service.create(c);
	}
	
	// modifier un ticket
	@RequestMapping(value = "/tickets", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public Ticket modifierTicket(@RequestBody Ticket c) {
		return service.update(c);
	}
	
	// supprimer un ticket
	@RequestMapping(value = "/tickets/{numTicket}", //
	         method = RequestMethod.DELETE, //
	         produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public boolean deleteTicket(@PathVariable("numTicket") Long id) {
			return service.deleteById(id);
	}
		

} // fin classe
