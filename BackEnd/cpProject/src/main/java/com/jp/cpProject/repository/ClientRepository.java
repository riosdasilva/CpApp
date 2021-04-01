package com.jp.cpProject.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.jp.cpProject.model.Client;

public interface ClientRepository extends Repository<Client, Long> {

	// metodo que guarda o client apos o service de criaçao
	Client save(Client c);
	
	//metodo que obtem um client atraves do id
    Client getClientById(Long id);
    
    //metodo que apaga um cliente 
    Client deleteById(Long id);
    
    //metodo que lista todos os clientes existentes
    List<Client> findAll();
	
}
