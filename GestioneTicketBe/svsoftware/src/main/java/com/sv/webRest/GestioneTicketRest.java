package com.sv.webRest;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.domain.GestioneTicket;
import com.sv.service.GestioneTicketService;
import com.sv.service.dto.TicketDTO;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class GestioneTicketRest {

	
	//crud 
	@Autowired
	private GestioneTicketService gestioneTicketService;

	@PostMapping("/gestione")
	public GestioneTicket addGestione(@RequestBody GestioneTicket gestioneT) {
		return this.gestioneTicketService.addGestioneTicket(gestioneT);
	}

	@GetMapping("/gestione/{id}")
	public GestioneTicket getGestioneById(@PathVariable long id) {
		return this.gestioneTicketService.getGestioneTicketById(id);
	}
	

	
	@GetMapping("/gestione")
	public List<GestioneTicket> getAllGestioniTicket() {
		return this.gestioneTicketService.getAllGestioneTicket();
	}

	@PutMapping("/gestione")
	public GestioneTicket updateGestioneTicket(@RequestBody GestioneTicket gestioneT) {
		return this.gestioneTicketService.updGestioneTicket(gestioneT);
	}

	@DeleteMapping("/gestione/{id}")
	public void deleteGestioneTicket(@PathVariable long id) {
		this.gestioneTicketService.deleteGestioneTicket(id);
	}
	
	//customs
	
	@PostMapping("/ticket")
	public int getTicketMeseMatricola(@RequestBody TicketDTO tDTO) {
		return this.gestioneTicketService.getGiorniLavoratiMeseMatricola(tDTO);
	}
}
