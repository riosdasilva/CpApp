package com.jp.cpProject.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.jp.cpProject.model.Review;

public interface ReviewRepository extends Repository<Review, Long> {

	// metodo que guarda o review apos o service de criaçao
	Review save(Review c);

	// metodo que obtem um review atraves do id
	Review getReviewById(Long id);

	// metodo que apaga um review
	Review deleteById(Long id);

	// metodo que lista todos os reviews existentes
	List<Review> findAll();

}