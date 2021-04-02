package com.jp.cpProject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.Client;
import com.jp.cpProject.model.ExceptionRuntime;
import com.jp.cpProject.repository.ClientRepository;

import jwt.JwtTokenProvider;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	JwtTokenProvider tokenProvider;

	AuthenticationManager authenticationManager;

	// servico que cria um cliente e retorna
	public Client save(Client cli) {
		emailExist(cli);
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

	// metodo que executa o login do cliente
	public Map<Object, Object> loginCli(String email, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

		Client cli = repository.findClientByEmail(email);

		String token = "";

		if (cli != null) {
			token = tokenProvider.createToken(email);
		} else {
			throw new ExceptionRuntime("Email " + email + "and password " + password + "not found");
		}

		Map<Object, Object> model = new HashMap<>();
		model.put("email", email);
		model.put("password", password);
		return model;

	}
}
