import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(protected http: HttpClient) { }

  url = "http://localhost:9098/api/gestione"
  url1= "http://localhost:9098/api/ticket"


  public getGestioneTicket(){
    return this.http.get(this.url);
  }
  public getGestioneMatricolaById(id : Number){
    return this.http.get(`${this.url}/${id}`);
  }

  public insertTicket(tDTO: any){
    return this.http.post(this.url1,tDTO);
  }

}
