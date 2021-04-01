package com.jp.cpProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.Client;
import com.jp.cpProject.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	// servico que cria um cliente e retorna
	public Client save(Client cli) {
		return repository.save(cli);
	}

	// servico que obtem um client e retorna
	public Client getClientById(Long id) {
		return repository.getClientById(id);
	}

	// servico que faz update a um client (para ja numa primeira versao faz a todos
	// os campos de negocio)
	public Client updateCli(Long id, Client c) {
		Client cli = getClientById(id);
		cli.setName(c.getName());
		cli.setEmail(c.getEmail());
		cli.setNationaly(c.getNationaly());
		cli.setPassword(c.getPassword());
		return repository.save(cli);
	}

	// servico que faz delete a um client atraves do seu id
	public Client deleteById(Long id) {
		return repository.deleteById(id);
	}
	
	//servico que faz listagem de todos os clientes existentes no momento
	public List<Client> listAll(){
		return repository.findAll();
	}
}
