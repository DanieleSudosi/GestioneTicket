import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormMatricolaComponent } from './form-matricola/form-matricola.component';
import { HomepageComponent } from './homepage/homepage.component';
import { TabulatiComponent } from './tabulati/tabulati.component';
import { TicketFormComponent } from './ticket-form/ticket-form.component';

const routes: Routes = [
 {path: '', component:HomepageComponent},
 {path:'tabulati',component:TabulatiComponent},
 {path:'videata',component:TicketFormComponent},
 {path:'matricola',component:FormMatricolaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
