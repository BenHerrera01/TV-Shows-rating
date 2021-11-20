package cl.desafiolatam.sistemaimdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.sistemaimdb.model.Rating;
import cl.desafiolatam.sistemaimdb.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public List<Rating> findAll() {
		return ratingRepository.findAll();
	}

	@Override
	public void addRate(Rating rating) {
		ratingRepository.save(rating);		
	}

	@Override
	public void editRate(Rating rating) {
		ratingRepository.save(rating);
	}

	@Override
	public void deleteRate(Rating rating) {
		ratingRepository.delete(rating);
		
	}

}
