import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { TabulatiService } from '../services/tabulati.service';

@Component({
  selector: 'app-form-matricola',
  templateUrl: './form-matricola.component.html',
  styleUrls: ['./form-matricola.component.css']
})
export class FormMatricolaComponent implements OnInit {

  constructor(private route: Router,
    private service: TabulatiService,
    private formBuilder: FormBuilder
  ) { }


  form: FormGroup = this.formBuilder.group({
    numMatricola: [''],
    nome: [''],
    cognome: [''],
    dataNascita: [''],
  });

  matricola: any = [];

  ngOnInit(): void {
  }


  aggiungiMatricola() {
    this.service.addMatricola(this.form.value).subscribe(() => {
      alert('matricola inserita correttamente')
    });


  }
}
