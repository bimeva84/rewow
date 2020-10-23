package co.com.rewow.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.rewow.entity.Dueno;

@Repository
public interface DuenoRepository extends JpaRepository<Dueno, Integer> {

	@Query("SELECT dn FROM Dueno dn WHERE UPPER(dn.duenoNombre) =UPPER(?1)")
	public List<Dueno> consutaDuenoPorNombre (String nombre)throws SQLException;
}
