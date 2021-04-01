package com.jp.cpProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.Stop;
import com.jp.cpProject.repository.StopRepository;

@Service
public class StopService {

	@Autowired
	private StopRepository repository;

	// servico que cria uma paragem e retorna
	public Stop save(Stop stop) {
		return repository.save(stop);
	}

	// servico que obtem um client e retorna
	public Stop getStopById(Long id) {
		return repository.getStopById(id);
	}

	// servico que faz update a uma paragem (para ja numa primeira versao faz a
	// todos
	// os campos de negocio)
	public Stop updateStop(Long id, Stop s) {
		Stop stop = getStopById(id);
		stop.setSeatsToNextStop(s.getSeatsToNextStop());
		stop.setStopTime(s.getStopTime());
		stop.setStation(s.getStation());
		stop.setNextStation(s.getNextStation());
		return repository.save(stop);
	}

	// servico que faz delete a uma paragem atraves do seu id
	public Stop deleteById(Long id) {
		return repository.deleteById(id);
	}

	// servico que faz listagem de todos as paragem existentes no momento
	public List<Stop> listAll() {
		return repository.findAll();
	}
}
