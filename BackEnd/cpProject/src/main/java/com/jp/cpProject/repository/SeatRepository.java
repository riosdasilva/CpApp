package com.jp.cpProject.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.jp.cpProject.model.Seat;

public interface SeatRepository extends Repository<Seat, Long> {

	// metodo que guarda o client apos o Seat de criaçao
	Seat save(Seat c);

	// metodo que obtem um Seat atraves do id
	Seat getSeatById(Long id);

	// metodo que apaga um Seat
	Seat deleteById(Long id);

	// metodo que lista todos os Seats existentes
	List<Seat> findAll();

}