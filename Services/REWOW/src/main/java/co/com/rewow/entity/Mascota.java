package co.com.rewow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="mascota")
public class Mascota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_mascota1")
	@SequenceGenerator(name = "sec_mascota1", sequenceName = "sec_mascota", allocationSize = 1)
    @Column(name = "mascota_id", nullable = false, length = 6)
    private Integer mascotaId;

    @Column(name = "mascota_nombre", nullable = false, length = 50)
    private String mascotaNombre;
    
    public Integer getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(Integer mascotaId) {
        this.mascotaId = mascotaId;
    }

    public String getMascotaNombre() {
        return mascotaNombre;
    }

    public void setMascotaNombre(String mascotaNombre) {
        this.mascotaNombre = mascotaNombre;
    }

}
