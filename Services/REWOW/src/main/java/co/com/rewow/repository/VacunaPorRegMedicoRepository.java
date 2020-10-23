package co.com.rewow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.rewow.entity.VacunaPorRegMedico;

@Repository
public interface VacunaPorRegMedicoRepository extends JpaRepository<VacunaPorRegMedico, Integer>{

}
