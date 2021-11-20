package cl.desafiolatam.sistemaimdb.service;

import java.util.List;

import cl.desafiolatam.sistemaimdb.model.Show;

public interface ShowService {
	List<Show> findAll();
	void addShow(Show show);
	void editShow(Show show);
	void deleteShow(Show show);
	Show findById(Long id);
}
