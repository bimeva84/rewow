package co.com.rewow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_mascosta")
public class TipoMascota {
	@Id
    @Column(name = "tipo_mascota_id", nullable = false, length = 6)
    private Integer tipoMascotaId;

    @Column(name = "tipo_mascota_desc", nullable = false, length = 50)
    private String tipoMascotaDesc;
    
    @Column(name = "tipo_mascota_estado", nullable = false, length = 1)
    private String tipoMascotaEstado;

	public Integer getTipoMascotaId() {
		return tipoMascotaId;
	}

	public void setTipoMascotaId(Integer tipoMascotaId) {
		this.tipoMascotaId = tipoMascotaId;
	}

	public String getTipoMascotaDesc() {
		return tipoMascotaDesc;
	}

	public void setTipoMascotaDesc(String tipoMascotaDesc) {
		this.tipoMascotaDesc = tipoMascotaDesc;
	}

	public String getTipoMascotaEstado() {
		return tipoMascotaEstado;
	}

	public void setTipoMascotaEstado(String tipoMascotaEstado) {
		this.tipoMascotaEstado = tipoMascotaEstado;
	}
    
   

}
