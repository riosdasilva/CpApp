package com.jp.cpProject.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.jp.cpProject.model.Stop;

public interface StopRepository extends Repository<Stop, Long> {

	// metodo que guarda a paragem apos o service de criaçao
	Stop save(Stop c);
	
	//metodo que obtem uma paragem atraves do id
    Stop getStopById(Long id);
    
    //metodo que apaga uma paragem 
    Stop deleteById(Long id);
    
    //metodo que lista todos as paragens existentes
    List<Stop> findAll();
	
}
