package co.com.rewow.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="vacuna")
public class Vacuna {
	
	@Id
    @Column(name = "vacuna_id", nullable = false, length = 6)
    private Integer vacunaId;

    @Column(name = "vacuna_numero", nullable = false, length = 10)
    private String vacunaNumero;
    
    @ManyToOne
    @JoinColumn(name = "vacuna_tipo_vacuna_id", nullable = false)
    private TipoVacuna vacunaTipoVacunaId;
    
    @Column(name = "vacuna_fecha")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Bogota")
    private Date vacunaFecha;
    
    public Integer getVacunaId() {
        return vacunaId;
    }

    public void setVacunaId(Integer vacunaId) {
        this.vacunaId = vacunaId;
    }

    public String getVacunaNumero() {
        return vacunaNumero;
    }

    public void setVacunaNumero(String vacunaNumero) {
        this.vacunaNumero = vacunaNumero;
    }
    public TipoVacuna getVacunaTipoVacunaId() {
        return vacunaTipoVacunaId;
    }

    public void setVacunaTipoVacunaId(TipoVacuna vacunaTipoVacunaId) {
        this.vacunaTipoVacunaId = vacunaTipoVacunaId;
    }
    public Date getVacunaFecha() {
        return vacunaFecha;
    }

    public void setVacunaFecha(Date vacunaFecha) {
        this.vacunaFecha = vacunaFecha;
    }

}
