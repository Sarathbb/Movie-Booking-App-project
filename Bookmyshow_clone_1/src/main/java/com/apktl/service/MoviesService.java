package com.apktl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apktl.model.MoviesDTO;
import com.apktl.repository.MoviesRepository;

@Service
public class MoviesService {

	@Autowired
	private MoviesRepository repo;
	
	public void saveMovies(MoviesDTO mdto) {
		repo.save(mdto);
	}
	
	public Iterable<MoviesDTO> getMovies() {
		Iterable<MoviesDTO> mdto = repo.findAll();
		
		return mdto;
	}
	
	public Optional<MoviesDTO> getMovieById(int id) {
		Optional<MoviesDTO> mdto = repo.findById(id);
		
		return mdto;
	}
	
	public void deleteMovies(int id)
	{
		repo.deleteById(id);
	}
}
