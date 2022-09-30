package com.sv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.domain.Matricola;

@Repository
public interface MatricolaRepository extends JpaRepository<Matricola, Long> {

	
	public Matricola findByNumMatricola(int numMatricola);
}
