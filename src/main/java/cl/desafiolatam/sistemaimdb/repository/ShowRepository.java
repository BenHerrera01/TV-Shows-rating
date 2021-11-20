package cl.desafiolatam.sistemaimdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.sistemaimdb.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>{
	List<Show> findAll();
	
	@Query("FROM Show where id=?1")
	Show findShowbyId(Long id);

}
