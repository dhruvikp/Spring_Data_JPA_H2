package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Director;
import com.simplilearn.entity.Movie;
import com.simplilearn.repository.DirectorRepository;
import com.simplilearn.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	DirectorRepository directorRepository;

	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		movieRepository.findAll().forEach(m -> movies.add(m));
		return movies;
	}

	public void saveMovie(Movie movie) {
		Optional<Director> opt = directorRepository.findByDirectorName(movie.getDirector().getDirectorName());
		if (opt.isPresent()) {
			Director d = opt.get();
			movie.setDirector(d);
		}

		movieRepository.save(movie);
	}

	public void deleteMoveById(int id) {
		movieRepository.deleteById(id);
	}

	public List<String> getMovieNamesByDirectorName(String directorName) {
		List<Movie> movies = movieRepository.findMovieByDirectorName(directorName);
		;
		List<String> movieNames = new ArrayList<>();
		movies.forEach(m -> movieNames.add(m.getName()));
		return movieNames;
	}
}
