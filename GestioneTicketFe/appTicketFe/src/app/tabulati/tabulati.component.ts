import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TabulatiService } from '../services/tabulati.service';
import { TicketService } from '../services/ticket.service';

@Component({
  selector: 'app-tabulati',
  templateUrl: './tabulati.component.html',
  styleUrls: ['./tabulati.component.css']
})
export class TabulatiComponent implements OnInit {

  constructor(
    private service: TabulatiService) { }

  matricole: any = [];
  numMat: any;

  ngOnInit(): void {
    this.getMatricole();

  }
  getMatricole() {
    this.service.getMatricole().subscribe(res => {
      this.matricole = res;
    });
  }

  getByNumMatricola() {
    if (this.numMat) {
      this.service.getMatricolaByNumMatricola(this.numMat).subscribe(res =>{
    this.matricole = [res];    
      });
    }else{
      this.getMatricole();
    }
  }
}