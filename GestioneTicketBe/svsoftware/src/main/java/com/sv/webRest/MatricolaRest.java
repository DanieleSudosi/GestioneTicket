package com.sv.webRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.domain.Matricola;
import com.sv.service.MatricolaService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MatricolaRest {

	@Autowired
	private MatricolaService matricolaService;

	@PostMapping("/matricola")
	public Matricola addMatricola(@RequestBody Matricola m) {
		return this.matricolaService.addMatricola(m);
	}

	@GetMapping("/matricola/{id}")
	public Matricola getMatricolaById(@PathVariable long id) {
		return this.matricolaService.getMatricolaById(id);
	}
	
	@GetMapping("/matricola/num/{numMatricola}")
	public Matricola getMatricolaByNumMatricola(@PathVariable int numMatricola) {
		return this.matricolaService.getByNumMatricola(numMatricola);
	}

	@GetMapping("/matricola")
	public List<Matricola> getMatricole() {
		return this.matricolaService.getMatricole();
	}

	@PutMapping("/matricola")
	public Matricola updateMatricola(@RequestBody Matricola m) {
		return this.matricolaService.updateMatricola(m);
	}

	@DeleteMapping("/matricola/{id}")
	public void deleteMatricola(@PathVariable long id) {
		this.matricolaService.deleteMatricola(id);
	}
}
