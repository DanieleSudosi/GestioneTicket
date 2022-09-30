package com.sv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.domain.Matricola;

import com.sv.repository.MatricolaRepository;

@Service
public class MatricolaService {

	@Autowired
	private MatricolaRepository matricolaRepo;

	public Matricola addMatricola(Matricola m) {
		return this.matricolaRepo.save(m);
	}

	public List<Matricola> getMatricole() {
		return this.matricolaRepo.findAll();
	}

	public Matricola updateMatricola(Matricola m) {
		return this.matricolaRepo.save(m);
	}

	public Matricola getMatricolaById(long id) {
		return matricolaRepo.findById(id).get();
	}

	public void deleteMatricola(long id) {
		matricolaRepo.deleteById(id);
	}
	
	public Matricola getByNumMatricola(int numMatricola) {
		return this.matricolaRepo.findByNumMatricola(numMatricola);
	}
	
}
