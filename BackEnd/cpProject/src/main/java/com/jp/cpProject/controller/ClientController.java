package com.jp.cpProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.cpProject.jwt.Database.AuthenticationHelper;
import com.jp.cpProject.model.Client;
import com.jp.cpProject.service.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private ClientService service;

	@Autowired
	private AuthenticationHelper authenticationHelper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Client getClientById(@PathVariable("id") Long id, @RequestHeader("Authorization") String token) {
		Client c = this.service.getClientById(id);
		return this.service.getClientByEmail(c.getEmail());
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody Client Cli) {
		Client client = this.service.save(Cli);
		return ResponseEntity.ok(client);
	}

	@PutMapping(value = "/edit/{email}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCli(@PathVariable("email") String email, @RequestBody Client CliInput) {
		Client client = this.service.updateCli(email, CliInput);
		return ResponseEntity.ok(client);
	}

	@DeleteMapping(value = "/del/{id}")
	public Client deleteById(@PathVariable("id") Long id) {
		return this.service.deleteById(id);
	}

	@GetMapping(value = "/list")
	public List<Client> listAll() {
		return this.service.listAll();
	}
}
