package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.entities.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer> {
	@Query("select l from Libro l where l.tema.tema=?1")
	List<Libro> findByTema(String tema);
}
