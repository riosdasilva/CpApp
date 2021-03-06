package com.jp.cpProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.Client;
import com.jp.cpProject.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	// servico que cria um cliente e retorna
	public Client save(Client cli) {
		emailExist(cli);
		cli.setPassword(bcryptEncoder.encode(cli.getPassword()));
		return repository.save(cli);
	}

	// servico que obtem um client e retorna
	public Client getClientByEmail(String email) {
		return repository.findClientByEmail(email);
	}
	
	// servico que obtem um client e retorna
    public Client getClientById(Long id) {
	   return repository.findClientById(id);
    }

	// servico que faz update a um client (para ja numa primeira versao faz a todos
	// os campos de negocio)
	public Client updateCli(String email, Client c) {
		Client cli = getClientByEmail(email);
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

	// servico que faz listagem de todos os clientes existentes no momento
	public List<Client> listAll() {
		return repository.findAll();
	}

	// metodo que valida se o email inserido já existe ou não
	public void emailExist(Client cli) {
		String email = cli.getEmail();
		List<String> emails = repository.findAllEmail();
		for (int i = 0; i < emails.size(); i++) {
			if (email.equals(emails.get(i)) == true) {
				throw new RuntimeException("The email already exists! Please change to a new");
			}
		}
	}
}
