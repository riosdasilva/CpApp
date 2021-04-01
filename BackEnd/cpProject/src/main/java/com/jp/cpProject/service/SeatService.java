package com.jp.cpProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.Seat;
import com.jp.cpProject.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository repository;

	// servico que cria um Seat e retorna
	public Seat save(Seat cli) {
		return repository.save(cli);
	}

	// servico que obtem um Seat e retorna
	public Seat getSeatById(Long id) {
		return repository.getSeatById(id);
	}

	// servico que faz update a um Seat para ja numa primeira versao faz a todos
	// os campos de negocio)
	public Seat updateSeat(Long id, Seat s) {
		Seat seat = getSeatById(id);
		seat.setDate(s.getDate());
		seat.setStop(s.getStop());
		return repository.save(seat);
	}

	// servico que faz delete a um Seat atraves do seu id
	public Seat deleteById(Long id) {
		return repository.deleteById(id);
	}

	// servico que faz listagem de todos os Seats existentes no momento
	public List<Seat> listAll() {
		return repository.findAll();
	}
}
