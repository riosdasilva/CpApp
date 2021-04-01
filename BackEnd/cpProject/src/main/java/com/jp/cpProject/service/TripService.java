package com.jp.cpProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.Trip;
import com.jp.cpProject.repository.TripRepository;

@Service
public class TripService {

	@Autowired
	private TripRepository repository;

	// servico que cria um trip e retorna
	public Trip save(Trip trip) {
		return repository.save(trip);
	}

	// servico que obtem um trip e retorna
	public Trip getTripById(Long id) {
		return repository.getTripById(id);
	}

	// servico que faz update a uma trip (para ja numa primeira versao faz a todos
	// os campos de negocio)
	public Trip updateTrip(Long id, Trip t) {
		Trip trip = getTripById(id);
		trip.setInitialTime(t.getInitialTime());
		trip.setFinalTime(t.getFinalTime());
		trip.setInitialStation(t.getInitialStation());
		trip.setFinalStation(t.getFinalStation());
		return repository.save(trip);
	}

	// servico que faz delete a uma trip atraves do seu id
	public Trip deleteById(Long id) {
		return repository.deleteById(id);
	}

	// servico que faz listagem de todos as trips existentes no momento
	public List<Trip> listAll() {
		return repository.findAll();
	}
}
