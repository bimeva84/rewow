package co.com.rewow.dto;

public class RegistroMedicoDto {
	Integer registroId;
	String nombreDueno;
	String nombreMascota;
	Integer tipoMascota;
	String tamaño;
	String descripcion;
	

	public Integer getRegistroId() {
		return registroId;
	}
	public void setRegistroId(Integer registroId) {
		this.registroId = registroId;
	}
	public String getNombreDueno() {
		return nombreDueno;
	}
	public void setNombreDueno(String nombreDueno) {
		this.nombreDueno = nombreDueno;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public Integer getTipoMascota() {
		return tipoMascota;
	}
	public void setTipoMascota(Integer tipoMascota) {
		this.tipoMascota = tipoMascota;
	}
	public String getTamaño() {
		return tamaño;
	}
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
