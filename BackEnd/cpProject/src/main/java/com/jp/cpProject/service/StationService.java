package com.jp.cpProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.Station;
import com.jp.cpProject.repository.StationRepository;

@Service
public class StationService {

	@Autowired
	private StationRepository repository;

	// servico que cria um station e retorna
	public Station save(Station station) {
		return repository.save(station);
	}

	// servico que obtem um station e retorna
	public Station getStationById(Long id) {
		return repository.getStationById(id);
	}

	// servico que faz update a um station para ja numa primeira versao faz a todos
	// os campos de negocio)
	public Station updateStation(Long id, Station s) {
		Station station = getStationById(id);
		station.setName(s.getName());
		station.setStationNumber(s.getStationNumber());
		return repository.save(station);
	}

	// servico que faz delete a um station atraves do seu id
	public Station deleteById(Long id) {
		return repository.deleteById(id);
	}

	// servico que faz listagem de todos os stations existentes no momento
	public List<Station> listAll() {
		return repository.findAll();
	}
}
