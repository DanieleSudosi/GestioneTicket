package com.sv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table (name = "R_GESTIONE_TICKET")
@CrossOrigin
public class GestioneTicket {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_tabella")
		private long idTabella;
		
		@Column (name="mese_anno")
		@JsonFormat(pattern = "yyyy-MM")
		private String meseAnno;
		
		@Column(name="giorni_lavorativi")
		private int giorniLavorativi;
		
		@Column(name = "ferie_permessi_malattia")
		private int feriePermessiMalattia;
		
		@Column(name = "residuo")
		private int residuoTicketOre;
		

		@OneToOne
	    @JoinColumn(name = "id_matricola", referencedColumnName = "id_matricola")
	    private Matricola matricola;
		
		
		

		public GestioneTicket() {
			super();
		}

		public long getIdTabella() {
			return idTabella;
		}

		public void setIdTabella(long idTabella) {
			this.idTabella = idTabella;
		}

		public String getMeseAnno() {
			return meseAnno;
		}

		public void setMeseAnno(String meseAnno) {
			this.meseAnno = meseAnno;
		}

		public int getGiorniLavorativi() {
			return giorniLavorativi;
		}

		public void setGiorniLavorativi(int giorniLavorativi) {
			this.giorniLavorativi = giorniLavorativi;
		}

		public int getFeriePermessiMalattia() {
			return feriePermessiMalattia;
		}

		public void setFeriePermessiMalattia(int feriePermessiMalattia) {
			this.feriePermessiMalattia = feriePermessiMalattia;
		}

		public Matricola getMatricola() {
			return matricola;
		}

		public void setMatricola(Matricola matricola) {
			this.matricola = matricola;
		}
		
		public int getResiduoTicketOre() {
			return residuoTicketOre;
		}
		
		public void setResiduoTicketOre(int residuoTicketOre) {
			this.residuoTicketOre = residuoTicketOre;
		}
}