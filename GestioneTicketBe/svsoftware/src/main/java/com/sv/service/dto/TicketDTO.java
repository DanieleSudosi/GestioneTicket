package com.sv.service.dto;

import java.time.LocalDate;

public class TicketDTO {


	private LocalDate dataRiferimento;
	private int feriePermessiMalattia;
	private int numMatricola;


	public LocalDate getDataRiferimento() {
		return dataRiferimento;
	}

	public void setDataRiferimento(LocalDate dataRiferimento) {
		this.dataRiferimento = dataRiferimento;
	}

	public int getFeriePermessiMalattia() {
		return feriePermessiMalattia;
	}

	public void setFeriePermessiMalattia(int feriePermessiMalattia) {
		this.feriePermessiMalattia = feriePermessiMalattia;
	}

	public int getNumMatricola() {
		return numMatricola;
	}

	public void setNumMatricola(int numMatricola) {
		this.numMatricola = numMatricola;
	}



}
