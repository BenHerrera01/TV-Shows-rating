package cl.desafiolatam.sistemaimdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.sistemaimdb.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	List<Users> findAll();
	@Query("From Users where id=?1")
	Users FindById(Long id);
	Users findByEmail(String email);
	Users findByUsername(String username);
}
