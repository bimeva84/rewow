package co.com.rewow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.rewow.entity.TipoMascota;

@Repository
public interface TipoMascotaRepository extends JpaRepository<TipoMascota, Integer>{

}
