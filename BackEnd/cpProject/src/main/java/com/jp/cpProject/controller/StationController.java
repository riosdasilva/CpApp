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

import com.jp.cpProject.model.Station;
import com.jp.cpProject.service.StationService;

@RestController
@RequestMapping(value = "/station")
public class StationController {
    
	@Autowired
	private StationService service;
	
	@GetMapping(value = "/{id}")
	public Station getStationById(@PathVariable("id") Long id) {
	    return this.service.getStationById(id);
	}
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody Station Stat) {
        Station station = this.service.save(Stat);
        return ResponseEntity.ok(station);
    }
	
	@PutMapping(value = "/edit/{id}", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateStation(@PathVariable("id") Long id, @RequestBody Station StationInput) {
        Station station = this.service.updateStation(id, StationInput);
        return ResponseEntity.ok(station);
    }
	
	@DeleteMapping(value = "/del/{id}")
	public Station deleteById(@PathVariable("id") Long id) {
	    return this.service.deleteById(id);
	}
	
	@GetMapping(value = "/list")
	public List<Station> listAll() {
	    return this.service.listAll();
	}
}
