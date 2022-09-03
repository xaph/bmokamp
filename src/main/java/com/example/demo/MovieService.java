package com.example.demo;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Movie;
import com.example.demo.repository.ActorRepository;
import com.example.demo.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Valid
public class MovieService {

	private final MovieRepository movieRepository;

	private final ActorRepository actorRepository;

	public Movie create(Movie movie) {
		return movieRepository.save(movie);
	}

	public Movie update(Movie movie) {
		return movieRepository.save(movie);
	}

	public Movie addCast(Long movieId, Long actorId) {

		final Movie movie = movieRepository.findById(movieId).get();

		final Actor actor = actorRepository.findById(actorId).get();

		movie.getCast().add(actor);

		return movie;
	}

	public Optional<Movie> get(Long id) {
		//return movieRepository.findById(id);
		return movieRepository.findByIdWithCast(id);
	}

	public Iterable<Movie> list() {
		//return movieRepository.findAll();
		return movieRepository.findAllWithCast();
	}

}
