package com.jp.cpProject.repository;

import java.util.List;

import org.springframework.data.repository.Repository;
import com.jp.cpProject.model.CreditCard;

public interface CreditCardRepository extends Repository<CreditCard, Long> {

	// metodo que guarda o creditCard apos o service de criaçao
	CreditCard save(CreditCard c);

	// metodo que obtem um creditCard atraves do id
	CreditCard getCreditCardById(Long id);

	// metodo que apaga um creditCard
	CreditCard deleteById(Long id);

	// metodo que lista todos os creditCard existentes
	List<CreditCard> findAll();
}
