import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TabulatiService {

  constructor(protected http: HttpClient) { }

  url = "http://localhost:9098/api/matricola"


  public getMatricole(){
    return this.http.get(this.url);
  }
  public getMatricolaById(id : Number){
    return this.http.get(`${this.url}/${id}`);
  }

  public getMatricolaByNumMatricola(numMatricola : Number){
    return this.http.get(`${this.url}/num/${numMatricola}`);
  }

  public addMatricola(matricola: any){
    return this.http.post(this.url,matricola);
  }

}
