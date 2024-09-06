package init.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import init.entities.Tema;

public interface TemasDao extends JpaRepository<Tema, Integer> {

}
