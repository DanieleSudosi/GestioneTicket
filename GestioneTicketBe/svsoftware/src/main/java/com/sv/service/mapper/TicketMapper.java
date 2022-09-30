package com.sv.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.domain.GestioneTicket;
import com.sv.domain.Matricola;
import com.sv.repository.MatricolaRepository;
import com.sv.service.dto.TicketDTO;

@Service
public class TicketMapper {

	@Autowired
	private MatricolaRepository matricolaRepo;

//	public GestioneTicket toEntity(TicketDTO tDTO) {

//		GestioneTicket gt = new GestioneTicket();
//		gt.setMeseAnno(tDTO.getMeseAnno());
//		gt.setFeriePermessiMalattia(tDTO.getFeriePermessiMalattia());
//
//		Matricola m = matricolaRepo.findById(tDTO.getIdMatricola()).orElse(null);
//		gt.setMatricola(m);
//		return gt;

//	}
}
