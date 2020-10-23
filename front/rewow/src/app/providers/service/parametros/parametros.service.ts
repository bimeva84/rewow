import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import {ResponseService} from '../../../model/response.model';

@Injectable({
  providedIn: 'root'
})
export class ParametrosService {

  private endpoint = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public tiposMascotas(){
    return this.http.get(this.endpoint+"/parametro/consultarTiposMascotas").pipe(tap((resp: ResponseService)=> resp));
  }

  public listaVacunas(){
    return this.http.get(this.endpoint+"/parametro/listaVacunas").pipe(tap((resp: ResponseService)=> resp));
  }

}
