package cl.desafiolatam.sistemaimdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.sistemaimdb.model.Show;
import cl.desafiolatam.sistemaimdb.repository.ShowRepository;

@Service
public class ShowServiceImpl implements ShowService{
	@Autowired
	private ShowRepository showRepository;

	@Override
	public List<Show> findAll() {
		return showRepository.findAll();
	}

	@Override
	public void addShow(Show show) {
		showRepository.save(show);
	}

	@Override
	public void editShow(Show show) {
		showRepository.save(show);
	}

	@Override
	public void deleteShow(Show show) {
		showRepository.delete(show);
	}

	@Override
	public Show findById(Long id) {
		return showRepository.findShowbyId(id);
	}
	
	
}
