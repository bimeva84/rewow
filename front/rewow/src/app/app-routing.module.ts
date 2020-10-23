import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistroMedicoComponent } from './pages/negocio/registro-medico/registro-medico.component';

const routes: Routes = [
  {path: '', redirectTo: 'registroMedico', pathMatch: 'full' },
  {path: 'registroMedico', component:RegistroMedicoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
