package co.com.rewow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_vacuna")
public class TipoVacuna {
	
	@Id
    @Column(name = "tipo_vacuna_id", nullable = false, length = 6)
    private Integer tipoVacunaId;

    @Column(name = "tipo_vacuna_desc", nullable = false, length = 50)
    private String tipoVacunaDesc;
    
    public Integer getTipoVacunaId() {
        return tipoVacunaId;
    }

    public void setTipoVacunaId(Integer tipoVacunaId) {
        this.tipoVacunaId = tipoVacunaId;
    }

    public String getTipoVacunaDesc() {
        return tipoVacunaDesc;
    }

    public void setTipoVacunaDesc(String tipoVacunaDesc) {
        this.tipoVacunaDesc = tipoVacunaDesc;
    }

}
