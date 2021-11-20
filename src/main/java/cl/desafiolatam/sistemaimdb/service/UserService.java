package cl.desafiolatam.sistemaimdb.service;

import java.util.List;

import cl.desafiolatam.sistemaimdb.model.Users;

public interface UserService {
	List<Users> findAll();
	Users findById(Long id);
	void addUser(Users user);
	Users findByEmail(String email);
	boolean userExists(Users user);
}
