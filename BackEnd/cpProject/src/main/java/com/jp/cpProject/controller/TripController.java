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

import com.jp.cpProject.model.Trip;
import com.jp.cpProject.service.TripService;

@RestController
@RequestMapping(value = "/trip")
public class TripController {
    
	@Autowired
	private TripService service;
	
	@GetMapping(value = "/{id}")
	public Trip getTripById(@PathVariable("id") Long id) {
	    return this.service.getTripById(id);
	}
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody Trip trip) {
        Trip tri = this.service.save(trip);
        return ResponseEntity.ok(tri);
    }
	
	@PutMapping(value = "/edit/{id}", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateTrip(@PathVariable("id") Long id, @RequestBody Trip triInput) {
        Trip trip = this.service.updateTrip(id, triInput);
        return ResponseEntity.ok(trip);
    }
	
	@DeleteMapping(value = "/del/{id}")
	public Trip deleteById(@PathVariable("id") Long id) {
	    return this.service.deleteById(id);
	}
	
	@GetMapping(value = "/list")
	public List<Trip> listAll() {
	    return this.service.listAll();
	}
}
