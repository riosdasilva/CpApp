package com.jp.cpProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.cpProject.model.CreditCard;
import com.jp.cpProject.service.CreditCardService;

@RestController
@RequestMapping(value = "/credit")
public class CreditCardController {

	@Autowired
	private CreditCardService service;
	
	@GetMapping(value = "/{id}")
	public CreditCard getCreditCardById(@PathVariable("id") Long id) {
	    return this.service.getCreditCardById(id);
	}
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody CreditCard Cre) {
        CreditCard credit = this.service.save(Cre);
        return ResponseEntity.ok(credit);
    }
	
	@DeleteMapping(value = "/del/{id}")
	public CreditCard deleteById(@PathVariable("id") Long id) {
	    return this.service.deleteById(id);
	}
	
	@GetMapping(value = "/list")
	public List<CreditCard> listAll() {
	    return this.service.listAll();
	}
}
