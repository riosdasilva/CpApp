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

import com.jp.cpProject.model.Review;
import com.jp.cpProject.service.ReviewService;

@RestController
@RequestMapping(value = "/review")
public class ReviewController {

	@Autowired
	private ReviewService service;

	@GetMapping(value = "/{id}")
	public Review getReviewById(@PathVariable("id") Long id) {
		return this.service.getReviewById(id);
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody Review Rev) {
		Review review = this.service.save(Rev);
		return ResponseEntity.ok(review);
	}

	@PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateRev(@PathVariable("id") Long id, @RequestBody Review RevInput) {
		Review review = this.service.updateRev(id, RevInput);
		return ResponseEntity.ok(review);
	}

	@DeleteMapping(value = "/del/{id}")
	public Review deleteById(@PathVariable("id") Long id) {
		return this.service.deleteById(id);
	}

	@GetMapping(value = "/list")
	public List<Review> listAll() {
		return this.service.listAll();
	}
}
