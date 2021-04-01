package com.jp.cpProject.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.jp.cpProject.model.Inspector;

public interface InspectorRepository extends Repository<Inspector, Long> {

	// metodo que guarda o inspector apos o service de criaçao
	Inspector save(Inspector c);
	
	//metodo que obtem um inspector atraves do id
    Inspector getInspectorById(Long id);
    
    //metodo que apaga um inspector 
    Inspector deleteById(Long id);
    
    //metodo que lista todos os inspetores existentes
    List<Inspector> findAll();
	
}