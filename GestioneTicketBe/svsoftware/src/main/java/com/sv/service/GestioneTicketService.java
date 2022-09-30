package com.sv.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.domain.GestioneTicket;
import com.sv.domain.Matricola;
import com.sv.repository.GestioneTicketRepository;
import com.sv.repository.MatricolaRepository;
import com.sv.service.dto.TicketDTO;

@Service
public class GestioneTicketService {

	@Autowired
	private GestioneTicketRepository gestioneTicketRepo;

	@Autowired
	private MatricolaRepository matricolaRepo;

	public GestioneTicket addGestioneTicket(GestioneTicket gestioneT) {
		return this.gestioneTicketRepo.save(gestioneT);
	}

	public List<GestioneTicket> getAllGestioneTicket() {
		return this.gestioneTicketRepo.findAll();
	}

	public List<GestioneTicket> getByMeseAnnoAndMatricola(String meseAnno, Matricola matricola) {

		return this.gestioneTicketRepo.findByMeseAnnoAndMatricola(meseAnno, matricola);
	}

	public GestioneTicket getByResiduoTicketOre(int residuo) {
		return this.gestioneTicketRepo.findByResiduoTicketOre(residuo);
	}

	public GestioneTicket updGestioneTicket(GestioneTicket gestioneT) {
		return this.gestioneTicketRepo.save(gestioneT);
	}

	public GestioneTicket getGestioneTicketById(long id) {
		return gestioneTicketRepo.findById(id).get();
	}

	public void deleteGestioneTicket(long id) {
		gestioneTicketRepo.deleteById(id);
	}

	public int getGiorniLavoratiMeseMatricola(TicketDTO tDTO) {

		String formattazioneData = "yyyy-MM";
		DateTimeFormatter formattazioneDateTimeFormatter = DateTimeFormatter.ofPattern(formattazioneData);
		LocalDate inizioDate = tDTO.getDataRiferimento().minusMonths(1).withDayOfMonth(1);
		LocalDate fineDate = inizioDate.withDayOfMonth(inizioDate.lengthOfMonth());
		int ticket = 8;
		int giorniLavorativi = 0;
		int oreTotaliLavorate = 0;
		int ticketDaErogare = 0;
		int residuoTicketMesePrecedente = 0;
		int residuoTicketMeseAttuale = 0;

		MonthDay md = MonthDay.of(12, 25);
		Year year = Year.of(tDTO.getDataRiferimento().getYear());
		LocalDate natale = year.atMonthDay(md);

		MonthDay md1 = MonthDay.of(01, 01);
		Year year1 = Year.of(tDTO.getDataRiferimento().getYear());
		LocalDate primoGennaio = year.atMonthDay(md1);

		LocalDate[] festivita = { natale, primoGennaio };

		Matricola mat = this.matricolaRepo.findByNumMatricola(tDTO.getNumMatricola());

		if (inizioDate.isEqual(fineDate)) {
			return 0;
		}
		do {
			if (!inizioDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)
					&& !inizioDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
//				&& !inizioDate.equals(natale)
				giorniLavorativi++;
				inizioDate = inizioDate.plusDays(1);
			} else {
				inizioDate = inizioDate.plusDays(1);
			}
		} while (!inizioDate.isAfter(fineDate));

		oreTotaliLavorate = (giorniLavorativi * ticket) - tDTO.getFeriePermessiMalattia();

		List<GestioneTicket> gtMesePrecedente = this.gestioneTicketRepo.findByMeseAnnoAndMatricola(
				tDTO.getDataRiferimento().minusMonths(1).format(formattazioneDateTimeFormatter), mat);

		List<GestioneTicket> gtMeseAttuale = this.gestioneTicketRepo
				.findByMeseAnnoAndMatricola(tDTO.getDataRiferimento().format(formattazioneDateTimeFormatter), mat);

		if (!gtMesePrecedente.isEmpty() && gtMesePrecedente != null) {
			residuoTicketMesePrecedente = gtMesePrecedente.get(0).getResiduoTicketOre();

			residuoTicketMeseAttuale = (oreTotaliLavorate + residuoTicketMesePrecedente) % ticket;
		} else {
			residuoTicketMeseAttuale = (oreTotaliLavorate + 0) % ticket;
		}

		int residuo = ((giorniLavorativi * ticket) - residuoTicketMesePrecedente) % ticket;

		ticketDaErogare = (int) Math.floor((oreTotaliLavorate + residuoTicketMesePrecedente) / ticket);

		GestioneTicket gt = new GestioneTicket();

		if (!gtMeseAttuale.isEmpty()) {
			gt.setIdTabella(gtMeseAttuale.get(0).getIdTabella());
		}
		gt.setGiorniLavorativi(giorniLavorativi);
		gt.setMeseAnno(tDTO.getDataRiferimento().format(formattazioneDateTimeFormatter));
		gt.setMatricola(mat);

		gt.setFeriePermessiMalattia(tDTO.getFeriePermessiMalattia());
		gt.setResiduoTicketOre(residuoTicketMeseAttuale);
		this.gestioneTicketRepo.save(gt);

		if (residuoTicketMesePrecedente + residuo >= ticket) {
			ticketDaErogare++;
			System.out.println(ticketDaErogare);
		}
		return ticketDaErogare;

	}

//	Public Function Festivo(myDate As Date) As Boolean
//	Select Case myDate
//	'1. GENNAIO NUOVO ANNO
//	Case DateSerial(year(myDate), 1, 1)
//	Festivo = True
//
//	'6.GENNAIO - EPIFANIA
//	Case DateSerial(year(myDate), 1, 6)
//	Festivo = True
//
//	'25. APRILE - LIBERAZIONE
//	Case DateSerial(year(myDate), 4, 25)
//	Festivo = True
//
//	'1. MAGGIO FESTA LAVORATORI
//	Case DateSerial(year(myDate), 5, 1)
//	Festivo = True
//
//	'2. GIUGNO FESTA DELLA REPUBBLICA
//	Case DateSerial(year(myDate), 6, 2)
//	Festivo = True
//
//	'PASQUA
//	Case Easter(year(myDate))
//	Festivo = True
//
//	'LUNEDI DI PASQUA
//	Case Easter(year(myDate)) + 1
//	Festivo = True
//
//	'15. AGOSTO
//	Case DateSerial(year(myDate), 8, 15)
//	Festivo = True
//
//	'1. NOVEMBRE - TUTTI I SANTI
//	Case DateSerial(year(myDate), 11, 1)
//	Festivo = True
//
//	'8. DICEMBRE - IMMACOLATA CONCEZIONE
//	Case DateSerial(year(myDate), 12, 8)
//	Festivo = True
//
//	'25. DICEMBRE - NATALE
//	Case DateSerial(year(myDate), 12, 25)
//	Festivo = True
//
//	'26. DICEMBRE - SANTO STEFANO
//	Case DateSerial(year(myDate), 12, 26)
//	Festivo = True
//
//	' DATE DI FESTIVITA' LOCALI(PATRONO Ecc...)
//	'Case DateSerial(year(myDate), nn, nn)
//	' Festivo = True

//	' CALCOLO DELLA PASQUA
//	Function Easter(year As Integer) As Date
//	Dim d As Integer
//	d = (((255 - 11 * (year Mod 19)) - 21) Mod 30) + 21
//	Easter = DateSerial(year, 3, 1) + d + (d > 48) + 6 - _
//	((year + year \ 4 + d + (d > 48) + 1) Mod 7)
//	End Function
}
