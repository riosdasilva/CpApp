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

import com.jp.cpProject.model.Seat;
import com.jp.cpProject.service.SeatService;

@RestController
@RequestMapping(value = "/seat")
public class SeatController {

	@Autowired
	private SeatService service;

	@GetMapping(value = "/{id}")
	public Seat getSeatById(@PathVariable("id") Long id) {
		return this.service.getSeatById(id);
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody Seat S) {
		Seat seat = this.service.save(S);
		return ResponseEntity.ok(seat);
	}

	@PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateSeat(@PathVariable("id") Long id, @RequestBody Seat SInput) {
		Seat seat = this.service.updateSeat(id, SInput);
		return ResponseEntity.ok(seat);
	}

	@DeleteMapping(value = "/del/{id}")
	public Seat deleteById(@PathVariable("id") Long id) {
		return this.service.deleteById(id);
	}

	@GetMapping(value = "/list")
	public List<Seat> listAll() {
		return this.service.listAll();
	}
}
