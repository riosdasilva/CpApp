package com.jp.cpProject.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.jp.cpProject.model.Station;

public interface StationRepository extends Repository<Station, Long> {

	// metodo que guarda o station apos o service de criaçao
	Station save(Station c);

	// metodo que obtem um station atraves do id
	Station getStationById(Long id);

	// metodo que apaga um station
	Station deleteById(Long id);

	// metodo que lista todos os stations existentes
	List<Station> findAll();

}