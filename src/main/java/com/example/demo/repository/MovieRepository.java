package com.example.demo.repository;

import com.example.demo.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.JoinColumn;
import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Long> {

	@Query("SELECT m from Movie m left join fetch m.cast")
	Iterable<Movie> findAllWithCast();

	@Query("select m from Movie m left join fetch m.cast where m.id = :id")
	Optional<Movie> findByIdWithCast(Long id);
}
