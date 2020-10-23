package co.com.rewow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vacregmed")
public class VacunaPorRegMedico {

	@Id
    @Column(name = "vacregmed_id", nullable = false, length = 6)
    private Integer vacregmedId;
	
	@ManyToOne
    @JoinColumn(name = "vacregmed_vacuna_id", nullable = false)
    private Vacuna vacregmedVacunaId;
	
	@ManyToOne
    @JoinColumn(name = "vacregmed_regmed_id", nullable = false)
    private RegistroMedico vacregmedRegmedId;

	public Integer getVacregmedId() {
		return vacregmedId;
	}

	public void setVacregmedId(Integer vacregmedId) {
		this.vacregmedId = vacregmedId;
	}

	public Vacuna getVacregmedVacunaId() {
		return vacregmedVacunaId;
	}

	public void setVacregmedVacunaId(Vacuna vacregmedVacunaId) {
		this.vacregmedVacunaId = vacregmedVacunaId;
	}

	public RegistroMedico getVacregmedRegmedId() {
		return vacregmedRegmedId;
	}

	public void setVacregmedRegmedId(RegistroMedico vacregmedRegmedId) {
		this.vacregmedRegmedId = vacregmedRegmedId;
	}	
	
}
