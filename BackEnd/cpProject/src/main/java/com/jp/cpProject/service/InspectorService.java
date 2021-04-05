package com.jp.cpProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.cpProject.model.Client;
import com.jp.cpProject.model.Inspector;
import com.jp.cpProject.repository.InspectorRepository;

@Service
public class InspectorService {

	@Autowired
	private InspectorRepository repository;

	// servico que cria um inspetor e retorna
	public Inspector save(Inspector cli) {
		return repository.save(cli);
	}

	// servico que obtem um inspetor e retorna
	public Inspector getInspectorByEmail(String email) {
		return repository.getInspectorByEmail(email);
	}

	public Client getInspectorById(Long id) {
		return repository.findInspectorById(id);
	}

	// servico que faz update a um inspetor para ja numa primeira versao faz a todos
	// os campos de negocio)
	public Inspector updateImp(String email, Inspector i) {
		Inspector imp = getInspectorByEmail(email);
		imp.setName(i.getName());
		imp.setEmail(i.getEmail());
		imp.setNationaly(i.getNationaly());
		imp.setPassword(i.getPassword());
		return repository.save(imp);
	}

	// servico que faz delete a um inspetor atraves do seu id
	public Inspector deleteById(Long id) {
		return repository.deleteById(id);
	}

	// servico que faz listagem de todos os inspetores existentes no momento
	public List<Inspector> listAll() {
		return repository.findAll();
	}
}