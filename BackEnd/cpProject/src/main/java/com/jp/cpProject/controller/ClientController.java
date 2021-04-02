package com.jp.cpProject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.cpProject.model.Client;
import com.jp.cpProject.service.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping(value = "/{id}")
	public Client getClientById(@PathVariable("id") Long id) {
		return this.service.getClientById(id);
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody Client Cli) {
		Client client = this.service.save(Cli);
		return ResponseEntity.ok(client);
	}

	@PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCli(@PathVariable("id") Long id, @RequestBody Client CliInput) {
		Client client = this.service.updateCli(id, CliInput);
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

	@PostMapping(value = "/logIn", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> loginCli(@RequestBody String email, String password) {
		Map<Object, Object> model = this.service.loginCli(email, password);
		return ResponseEntity.ok(model);
	}
}
