package com.jp.cpProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.jp.cpProject.model.Client;

public interface ClientRepository extends Repository<Client, Long> {

	// metodo que guarda o client apos o service de criaçao
	Client save(Client c);

	// metodo que obtem um client atraves do id
	Client getClientById(Long id);

	// metodo que apaga um cliente
	Client deleteById(Long id);

	// metodo que lista todos os clientes existentes
	List<Client> findAll();

	// metodo que obtem a lista de emails
	@Query(value = "SELECT email FROM user", nativeQuery = true)
	List<String> findAllEmail();

	// metodo que obtem a lista de clientes existentes
	@Query(value = "SELECT * FROM user WHERE user_type = 'C'", nativeQuery = true)
	List<Client> findAllClient();

	// metodo que obtem o cliente atraves do email
	@Query(value = "SELECT * FROM user WHERE user_type = 'C' and email = :email", nativeQuery = true)
	Client findClientByEmail(@Param("email") String email);

}
