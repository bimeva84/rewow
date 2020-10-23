package co.com.rewow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.rewow.entity.Vacuna;

@Repository
public interface VacunaRepository extends JpaRepository<Vacuna, Integer> {

}
