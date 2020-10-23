package co.com.rewow.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.rewow.entity.RegistroMedico;

@Repository
public interface RegistroMedicoRepository extends JpaRepository<RegistroMedico, Integer>{
	
	@Query("SELECT rm FROM RegistroMedico rm WHERE UPPER(rm.regMedicoDuenoId.duenoNombre) =UPPER(?1)")
	public List<RegistroMedico> consutaRegistroDueno (String nombre)throws SQLException;

}
