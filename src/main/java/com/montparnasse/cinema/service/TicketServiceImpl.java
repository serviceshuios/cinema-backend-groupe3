package com.montparnasse.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.montparnasse.cinema.dao.ITicketDao;
import com.montparnasse.cinema.domaine.Ticket;

public class TicketServiceImpl implements ITicketService{
	
	@Autowired
	private ITicketDao daoTicket;
	
	public ITicketDao getDaoTicket() {
		return daoTicket;
	}

	public void setDaoTicket(ITicketDao daoTicket) {
		this.daoTicket = daoTicket;
	}

	@Override
	public Ticket create(Ticket t) {
		return daoTicket.save(t);
	}

	@Override
	public Ticket update(Ticket t) {
		return daoTicket.save(t);
	}

	@Override
	public boolean deleteById(Long id) {
		daoTicket.deleteById(id);
		return false;
	}

	@Override
	public Ticket getById(Long id) {
		return daoTicket.findById(id).get();
	}

	@Override
	public List<Ticket> getAll() {
		return daoTicket.findAll();
	}
	
}
