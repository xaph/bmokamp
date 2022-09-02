package com.example.demo.controller;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MovieController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    List<Movie> list(@RequestParam(required = false) String q) {

        if(q != null) {

            //search movies by name

//            return movies.subList(0, 2);
            return null;
        }

        return (List<Movie>) movieRepository.findAll();
    }

    @PostMapping("/movies")
    ResponseEntity<Movie> create(@RequestBody Movie movie) {

        //store movie
//        movies.add(movie);
        movieRepository.save(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping("/movies/{id}")
    ResponseEntity<Movie> getMovie(@PathVariable Long id) {

        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isPresent()) {
            return ResponseEntity.ok(optionalMovie.get());
        } else {

            return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


//    GET /movies/1
//    POST /movies
//    PUT /movies/1
//    PATCH /movies/1
//    DELETE /movies/1


}
