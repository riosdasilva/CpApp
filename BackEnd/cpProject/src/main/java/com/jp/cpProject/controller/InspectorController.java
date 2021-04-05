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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.cpProject.model.Inspector;
import com.jp.cpProject.service.InspectorService;

@RestController
@RequestMapping(value = "/inspector")
public class InspectorController {

	@Autowired
	private InspectorService service;

	@GetMapping(value = "/{email}")
	public Inspector getInspectorById(@PathVariable("email") String email) {
		return this.service.getInspectorByEmail(email);
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody Inspector Imp) {
		Inspector inspector = this.service.save(Imp);
		return ResponseEntity.ok(inspector);
	}

	@PutMapping(value = "/edit/{email}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateImp(@PathVariable("id") String email, @RequestBody Inspector ImpInput) {
		Inspector inspector = this.service.updateImp(email, ImpInput);
		return ResponseEntity.ok(inspector);
	}

	@DeleteMapping(value = "/del/{id}")
	public Inspector deleteById(@PathVariable("id") Long id) {
		return this.service.deleteById(id);
	}

	@GetMapping(value = "/list")
	public List<Inspector> listAll() {
		return this.service.listAll();
	}
}
