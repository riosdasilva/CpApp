package com.jp.cpProject.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.jp.cpProject.model.Trip;

public interface TripRepository extends Repository<Trip, Long> {

	// metodo que guarda o trip apos o service de criaçao
	Trip save(Trip c);

	// metodo que obtem um trip atraves do id
	Trip getTripById(Long id);

	// metodo que apaga um trip
	Trip deleteById(Long id);

	// metodo que lista todos os trips existentes
	List<Trip> findAll();

}