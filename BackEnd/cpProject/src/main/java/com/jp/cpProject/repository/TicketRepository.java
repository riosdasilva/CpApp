package com.jp.cpProject.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.jp.cpProject.model.Ticket;

public interface TicketRepository extends Repository<Ticket, Long> {

	// metodo que guarda o ticket apos o service de criaçao
	Ticket save(Ticket c);

	// metodo que obtem um ticket atraves do id
	Ticket getTicketById(Long id);

	// metodo que apaga um ticket
	Ticket deleteById(Long id);

	// metodo que lista todos os tickets existentes
	List<Ticket> findAll();

}