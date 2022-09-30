import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { TicketService } from '../services/ticket.service';

@Component({
  selector: 'app-ticket-form',
  templateUrl: './ticket-form.component.html',
  styleUrls: ['./ticket-form.component.css']
})
export class TicketFormComponent implements OnInit {
  
  constructor(private route: Router,
    private service: TicketService,
    private formBuilder: FormBuilder
    ) { }
    
    
    form: FormGroup = this.formBuilder.group({
                dataRiferimento: [''],
                numMatricola: [''],
                feriePermessiMalattia:[''],
              });
              
  tickets: any =[];

  ticketDaErogare:any;
  

  
  ngOnInit(): void {
    this.getTicket();
       this.getCurrentDate();
  }
  
  public getTicket(){
    this.service.getGestioneTicket().subscribe((response) =>
    this.tickets = response)
  }


  public elabora(){
    console.log(this.form.value);
    console.log(new Date().toISOString().split('T')[0]);

    this.service.insertTicket(this.form.value).subscribe((response)=>
    this.ticketDaErogare = response)
  }


  public getCurrentDate(){
                          //nome    //valore
    this.form.patchValue({dataRiferimento: new Date().toISOString().split('T')[0]})
  }
}
