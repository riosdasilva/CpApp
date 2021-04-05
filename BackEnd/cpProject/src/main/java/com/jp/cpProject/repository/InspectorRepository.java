package com.jp.cpProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jp.cpProject.model.Client;
import com.jp.cpProject.model.Inspector;

public interface InspectorRepository extends Repository<Inspector, Long> {

	// metodo que guarda o inspector apos o service de criaçao
	Inspector save(Inspector c);

	// metodo que obtem um inspector atraves do email
	@Query(value = "SELECT * FROM user WHERE user_type = 'I' and email = :email", nativeQuery = true)
	Inspector getInspectorByEmail(String email);

	// metodo que apaga um inspector
	Inspector deleteById(Long id);

	// metodo que lista todos os inspetores existentes
	List<Inspector> findAll();

	// metodo que obtem o inspetor atraves do id)
	Client findInspectorById(Long id);

}