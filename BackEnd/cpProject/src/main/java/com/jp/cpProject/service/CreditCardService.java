package com.jp.cpProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.CreditCard;
import com.jp.cpProject.repository.CreditCardRepository;

@Service
public class CreditCardService {
	
	@Autowired
	private CreditCardRepository repository;

	// servico que cria um CreditCard e retorna
	public CreditCard save(CreditCard cli) {
		return repository.save(cli);
	}

	// servico que obtem um creditCard e retorna
	public CreditCard getCreditCardById(Long id) {
		return repository.getCreditCardById(id);
	}

	// servico que faz delete a um creditCard atraves do seu id
	public CreditCard deleteById(Long id) {
		return repository.deleteById(id);
	}
	
	//servico que faz listagem de todos os creditCards existentes no momento
	public List<CreditCard> listAll(){
		return repository.findAll();
	}
	

}
