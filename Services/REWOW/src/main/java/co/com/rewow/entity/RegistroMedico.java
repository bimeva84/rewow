package co.com.rewow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="reg_medico")
public class RegistroMedico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_regmed1")
	@SequenceGenerator(name = "sec_regmed1", sequenceName = "sec_regmed", allocationSize = 1)
    @Column(name = "reg_medico_id", nullable = false, length = 6)
    private Integer regMedicoId;
	
	@ManyToOne
    @JoinColumn(name = "reg_medico_dueno_id", nullable = false)
    private Dueno regMedicoDuenoId;
    
	@ManyToOne
    @JoinColumn(name = "reg_medico_mascota_id", nullable = false)
    private Mascota regMedicoMascotaId;
	
	@ManyToOne
    @JoinColumn(name = "reg_medico_tipo_mascota_id", nullable = false)
    private TipoMascota regMedicoTipoMascotaId;
	
	@Column(name = "reg_medico_tamano", length = 1)
    private String regMedicoTamano;
	
	@Column(name = "reg_medico_desc", length = 500)
    private String regMedicoDesc;

	public Integer getRegMedicoId() {
		return regMedicoId;
	}

	public void setRegMedicoId(Integer regMedicoId) {
		this.regMedicoId = regMedicoId;
	}

	public Dueno getRegMedicoDuenoId() {
		return regMedicoDuenoId;
	}

	public void setRegMedicoDuenoId(Dueno regMedicoDuenoId) {
		this.regMedicoDuenoId = regMedicoDuenoId;
	}

	public Mascota getRegMedicoMascotaId() {
		return regMedicoMascotaId;
	}

	public void setRegMedicoMascotaId(Mascota regMedicoMascotaId) {
		this.regMedicoMascotaId = regMedicoMascotaId;
	}

	public TipoMascota getRegMedicoTipoMascotaId() {
		return regMedicoTipoMascotaId;
	}

	public void setRegMedicoTipoMascotaId(TipoMascota regMedicoTipoMascotaId) {
		this.regMedicoTipoMascotaId = regMedicoTipoMascotaId;
	}

	public String getRegMedicoTamano() {
		return regMedicoTamano;
	}

	public void setRegMedicoTamano(String regMedicoTamano) {
		this.regMedicoTamano = regMedicoTamano;
	}

	public String getRegMedicoDesc() {
		return regMedicoDesc;
	}

	public void setRegMedicoDesc(String regMedicoDesc) {
		this.regMedicoDesc = regMedicoDesc;
	}

}
