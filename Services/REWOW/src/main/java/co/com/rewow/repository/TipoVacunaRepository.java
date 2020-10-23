package co.com.rewow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.rewow.entity.TipoVacuna;

@Repository
public interface TipoVacunaRepository extends JpaRepository<TipoVacuna, Integer> {

}
