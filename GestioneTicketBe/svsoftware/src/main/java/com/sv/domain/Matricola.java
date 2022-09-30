package com.sv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table (name = "T_MATRICOLE")
public class Matricola {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_matricola")
	private long idMatricola;
	
	@Column(name = "num_matricola")
	private int numMatricola; 
	
	@Column(name = "Nome")
	private String nome;
	
	@Column( name= "cognome")
	private String cognome;
	
	@Column(name="data_nascita")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String dataNascita;
	
	public Matricola() {
		// TODO Auto-generated constructor stub
	}

	public Matricola(long idMatricola, int numMatricola, String nome, String cognome, String dataNascita) {
		super();
		this.idMatricola = idMatricola;
		this.numMatricola = numMatricola;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}

	public long getIdMatricola() {
		return idMatricola;
	}

	public void setIdMatricola(long idMatricola) {
		this.idMatricola = idMatricola;
	}

	public int getNumMatricola() {
		return numMatricola;
	}

	public void setNumMatricola(int numMatricola) {
		this.numMatricola = numMatricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	
	
}
