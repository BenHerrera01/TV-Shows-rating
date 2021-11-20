package cl.desafiolatam.sistemaimdb.service;

import java.util.List;

import cl.desafiolatam.sistemaimdb.model.Rating;

public interface RatingService {
	List<Rating> findAll();
	void addRate(Rating rating);
	void editRate(Rating rating);
	void deleteRate(Rating rating);
}
