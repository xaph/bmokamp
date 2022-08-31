package com.example.demo.controller;

import com.example.demo.Hello;
import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
    Movie create(@RequestBody Movie movie) {

        //store movie
//        movies.add(movie);
        movieRepository.save(movie);

        return movie;
    }

//    @GetMapping("/movies/init")
//    List<Movie> init() {
//        Movie movie1 = new Movie(counter.incrementAndGet(), "titanic", "t12312", 1998, 120);
//        Movie movie2 = new Movie(counter.incrementAndGet(), "matrix", "t12313", 2001, 107);
//        Movie movie3 = new Movie(counter.incrementAndGet(), "lord of the rings", "t12314", 2003, 160);
//        Movie movie4 = new Movie(counter.incrementAndGet(), "harry potter", "t12315", 2005, 110);
//        Movie movie5 = new Movie(counter.incrementAndGet(), "iron man", "t12316", 2004, 108);
//
//        movies.add(movie1);
//        movies.add(movie2);
//        movies.add(movie3);
//        movies.add(movie4);
//        movies.add(movie5);
//
//
//        return movies;
//    }

}
