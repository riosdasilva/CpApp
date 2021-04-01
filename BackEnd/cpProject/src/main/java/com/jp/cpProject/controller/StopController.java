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

import com.jp.cpProject.model.Stop;
import com.jp.cpProject.service.StopService;

@RestController
@RequestMapping(value = "/stop")
public class StopController {

	@Autowired
	private StopService service;

	@GetMapping(value = "/{id}")
	public Stop getStopById(@PathVariable("id") Long id) {
		return this.service.getStopById(id);
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody Stop stop) {
		Stop s = this.service.save(stop);
		return ResponseEntity.ok(s);
	}

	@PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateStop(@PathVariable("id") Long id, @RequestBody Stop StopInput) {
		Stop stop = this.service.updateStop(id, StopInput);
		return ResponseEntity.ok(stop);
	}

	@DeleteMapping(value = "/del/{id}")
	public Stop deleteById(@PathVariable("id") Long id) {
		return this.service.deleteById(id);
	}

	@GetMapping(value = "/list")
	public List<Stop> listAll() {
		return this.service.listAll();
	}
}
