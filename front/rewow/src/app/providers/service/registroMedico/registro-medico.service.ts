import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import {ResponseService} from '../../../model/response.model';
import { RegistroMedicoModel } from 'src/app/model/registroMedico.model';

@Injectable({
  providedIn: 'root'
})
export class RegistroMedicoService {

  private endpoint = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public registroMedico(registroMedico:RegistroMedicoModel){
    return this.http.post(this.endpoint+"/registroMedico/registro",registroMedico).pipe(tap((resp: ResponseService)=> resp));
  }

  public consultaRegistro(nombreDueno:String){
    return this.http.post(this.endpoint+"/registroMedico/consultaRegistro",nombreDueno).pipe(tap((resp: ResponseService)=> resp));
  }

  public eliminarRegistro(registroId:String){
    return this.http.post(this.endpoint+"/registroMedico/eliminarRegistro",registroId).pipe(tap((resp: ResponseService)=> resp));
  }
}
