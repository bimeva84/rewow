import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { TipoMacotasModel } from 'src/app/model/tipoMascotas.model';
import { ParametrosService } from 'src/app/providers/service/parametros/parametros.service';
import { RegistroMedicoService } from 'src/app/providers/service/registroMedico/registro-medico.service';
import { ToastService } from 'src/app/providers/toast/toast.service';
import { RegistroMedicoModel } from '../../../model/registroMedico.model';

let ELEMENT_DATA: ListaVacunasElement[] = [];

@Component({
  selector: 'app-registro-medico',
  templateUrl: './registro-medico.component.html',
  styleUrls: ['./registro-medico.component.sass']
})
export class RegistroMedicoComponent implements OnInit {

  /** Variable para la validación del formulario */
  public form: FormGroup;
  public tipoMascota: TipoMacotasModel[]
  dataSource = new MatTableDataSource(ELEMENT_DATA);;
  displayedColumns: string[] = ['Numero', 'Tipo', 'Fecha'];
  registroId: number = null;

  constructor(private parametroService: ParametrosService,
    private formBuilder: FormBuilder,
    private registroMedicoService: RegistroMedicoService,
    private toast: ToastService) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      nombreDueno: new FormControl('', [Validators.required]),
      nombreMascota: new FormControl('', [Validators.required]),
      tipoMascota: new FormControl('', [Validators.required]),
      tamaño: new FormControl('', [Validators.required]),
      descripcion: new FormControl('', [Validators.required])
    })
    this.consultarParametros();
  }
  /**
   * 
   */
  consultarParametros() {
    this.parametroService.tiposMascotas().subscribe(
      res => {
        if (res.body) {
          this.tipoMascota = res.body
        }
        this.cargarVacunas()
      }, error => {
        console.log(error);
      }
    )
  }
  /**
   * 
   */
  cargarVacunas() {
    this.parametroService.listaVacunas().subscribe(
      res => {
        if (res.body) {
          res.body.forEach(x => {
            let elemento = { numero: x.vacunaId, tipo: x.vacunaTipoVacunaId.tipoVacunaDesc, fecha: x.vacunaFecha }
            ELEMENT_DATA.push(elemento);
          });
          this.dataSource = new MatTableDataSource(ELEMENT_DATA);
        }
      }
    )

  }
  /**
   * 
   */
  guardarRegistro() {
    if (this.form.valid) {
      let registroMedico: RegistroMedicoModel = {} as RegistroMedicoModel;
      registroMedico.registroId = this.registroId
      registroMedico.nombreDueno = this.form.get('nombreDueno').value
      registroMedico.nombreMascota = this.form.get('nombreMascota').value
      registroMedico.tipoMascota = this.form.get('tipoMascota').value
      registroMedico.tamaño = this.form.get('tamaño').value
      registroMedico.descripcion = this.form.get('descripcion').value
      this.registroMedicoService.registroMedico(registroMedico).subscribe(
        res => {
          if (res.status == 200) {
            this.toast.mensage(this.toast.exito, "Se realizo el registro medico exitosamente");
            this.limpiarRegistros()
          } else {
            this.toast.mensage(this.toast.error, "Error en el registro");
          }
        }
      )
    } else {
      this.toast.mensage(this.toast.alerta, "Campos Obligatorios no Ingresados");
    }
  }
  /**
   * 
   */
  consultaRegistro() {
    if (this.form.get('nombreDueno').valid) {
      this.registroMedicoService.consultaRegistro(this.form.get('nombreDueno').value).subscribe(
        res => {
          if (res.status == 200) {
            this.registroId = res.body.regMedicoId
            this.form.get('nombreDueno').setValue(res.body.regMedicoDuenoId.duenoNombre)
            this.form.get('nombreMascota').setValue(res.body.regMedicoMascotaId.mascotaNombre)
            this.form.get('tipoMascota').setValue(res.body.regMedicoTipoMascotaId.tipoMascotaId)
            this.form.get('tamaño').setValue(res.body.regMedicoTamano)
            this.form.get('descripcion').setValue(res.body.regMedicoDesc)
            this.form.updateValueAndValidity()
          } else if (res.status == 104) {
            this.toast.mensage(this.toast.alerta, "No se encontraron registros con el nombre ingresado");
          }
        }
      )
    } else {
      this.toast.mensage(this.toast.alerta, "Debe ingresar el nombre del dueño para poder consultar");
    }
  }
  /**
   * 
   */
  borrarRegistro() {
    if (this.registroId) {
      this.registroMedicoService.eliminarRegistro(this.registroId.toString()).subscribe(
        res=>{
          if(res.status == 200){
            this.toast.mensage(this.toast.exito, "Se elimino el registro exitosamente");
            this.limpiarRegistros()
          }else{
            this.toast.mensage(this.toast.error, "Error al eliminar el registro");
          }
        }
      )
    } else {
      this.toast.mensage(this.toast.alerta, "No existe registro para eliminar");
    }
  }
  /**
   * 
   */
  limpiarRegistros() {
    this.registroId = null;
    this.form.get('nombreDueno').setValue('')
    this.form.get('nombreMascota').setValue('')
    this.form.get('tipoMascota').setValue('')
    this.form.get('tamaño').setValue('')
    this.form.get('descripcion').setValue('')
    this.form.updateValueAndValidity()
  }

}

export interface ListaVacunasElement {
  numero: number;
  tipo: string;
  fecha: string;
}
