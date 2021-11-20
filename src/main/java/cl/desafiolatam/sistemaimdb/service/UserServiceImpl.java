package cl.desafiolatam.sistemaimdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.desafiolatam.sistemaimdb.model.Role;
import cl.desafiolatam.sistemaimdb.model.Users;
import cl.desafiolatam.sistemaimdb.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void addUser(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.USER_ROLE);
		userRepository.save(user);

	}

	@Override
	public Users findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public boolean userExists(Users user) {
		boolean exist = userRepository.findByEmail(user.getEmail()) !=null || userRepository.findByUsername(user.getUsername()) !=null ;
		return exist;
	}

	@Override
	public Users findById(Long id) {
		return userRepository.FindById(id);
	}


	
}
