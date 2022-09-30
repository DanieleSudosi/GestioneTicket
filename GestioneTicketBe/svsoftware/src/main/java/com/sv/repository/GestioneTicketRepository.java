package com.sv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.domain.GestioneTicket;
import com.sv.domain.Matricola;

@Repository
public interface GestioneTicketRepository extends JpaRepository<GestioneTicket, Long>{
	
	
	public List<GestioneTicket> findByMeseAnnoAndMatricola(String meseAnno,Matricola matricola);
	
	public GestioneTicket findByResiduoTicketOre(int residuo);
	
}
