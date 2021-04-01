package com.jp.cpProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.Ticket;
import com.jp.cpProject.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;

	// servico que cria um ticket e retorna
	public Ticket save(Ticket ticket) {
		return repository.save(ticket);
	}

	// servico que obtem um ticket e retorna
	public Ticket getTicketById(Long id) {
		return repository.getTicketById(id);
	}

	// servico que faz update a um ticket (para ja numa primeira versao faz a todos
	// os campos de negocio)
	public Ticket updateTicket(Long id, Ticket t) {
		Ticket ticket = getTicketById(id);
		ticket.setDate(t.getDate());
		ticket.setPrice(t.getPrice());
		ticket.setUsed(t.isUsed());
		ticket.setInspector(t.getInspector());
		ticket.setClient(t.getClient());
		ticket.setInitialStation(t.getInitialStation());
		ticket.setFinalStation(t.getFinalStation());
		ticket.setSeat(t.getSeat());
		return repository.save(ticket);
	}

	// servico que faz delete a um ticket atraves do seu id
	public Ticket deleteById(Long id) {
		return repository.deleteById(id);
	}

	// servico que faz listagem de todos os tickets existentes no momento
	public List<Ticket> listAll() {
		return repository.findAll();
	}
}
