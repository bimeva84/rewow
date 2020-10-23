package co.com.rewow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="dueno")
public class Dueno {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_dueno1")
	@SequenceGenerator(name = "sec_dueno1", sequenceName = "sec_dueno", allocationSize = 1)
    @Column(name = "dueno_id", nullable = false, length = 6)
    private Integer duenoId;

    @Column(name = "dueno_nombre", nullable = false, length = 100)
    private String duenoNombre;
    
    @Column(name = "dueno_telefono", length = 20)
    private String duenoTelefono;
    
    @Column(name = "dueno_direccion", length = 200)
    private String duenoDireccion;
    
    public Integer getDuenoId() {
        return duenoId;
    }

    public void setDuenoId(Integer duenoId) {
        this.duenoId = duenoId;
    }

    public String getDuenoNombre() {
        return duenoNombre;
    }

    public void setDuenoNombre(String duenoNombre) {
        this.duenoNombre = duenoNombre;
    }
    public String getDuenoTelefono() {
        return duenoTelefono;
    }

    public void setDuenoTelefono(String duenoTelefono) {
        this.duenoTelefono = duenoTelefono;
    }
    public String getDuenoDireccion() {
        return duenoDireccion;
    }

    public void setDuenoDireccion(String duenoDireccion) {
        this.duenoDireccion = duenoDireccion;
    }
}
