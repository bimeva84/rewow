package co.com.rewow.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.rewow.entity.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{
	
	@Query("SELECT ms FROM Mascota ms WHERE ms.mascotaNombre =?1")
	public List<Mascota> consutaMascotaPorNombre (String nombre)throws SQLException;

}
