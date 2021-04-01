package com.jp.cpProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.Review;
import com.jp.cpProject.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;

	// servico que cria um review e retorna
	public Review save(Review rev) {
		return repository.save(rev);
	}

	// servico que obtem um client e retorna
	public Review getReviewById(Long id) {
		return repository.getReviewById(id);
	}

	// servico que faz update a um rev (para ja numa primeira versao faz a todos
	// os campos de negocio)
	public Review updateRev(Long id, Review r) {
		Review rev = getReviewById(id);
		rev.setDescription(r.getDescription());
		rev.setRating(r.getRating());
		return repository.save(rev);
	}

	// servico que faz delete a um rev atraves do seu id
	public Review deleteById(Long id) {
		return repository.deleteById(id);
	}

	// servico que faz listagem de todos os rev existentes no momento
	public List<Review> listAll() {
		return repository.findAll();
	}
}
