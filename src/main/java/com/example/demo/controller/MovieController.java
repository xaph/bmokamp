package com.example.demo.controller;

import com.example.demo.MovieService;
import com.example.demo.entity.Actor;
import com.example.demo.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    Iterable<Movie> list() {
        return movieService.list();
    }

    @PostMapping("/movies")
    ResponseEntity<Movie> create(@RequestBody @Valid @Validated Movie movie, @AuthenticationPrincipal Object principle) {

        //if (movie.getName() == null || movie.getName().isEmpty()) {
        //    return ResponseEntity.badRequest().body("...");
        //}

        movieService.create(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @PutMapping("/movies/{id}")
    ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie movie) {

        movie.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.update(movie));
    }

    @PatchMapping("/movies/{id}/cast")
    ResponseEntity<Movie> addCast(@RequestBody @Valid AddCastRequest addCastRequest) {

        //if (addCastRequest.movieId == null || addCastRequest.actorId == null) {
        //    return ResponseEntity.badRequest().body("should not be null");
        //}

        return ResponseEntity.status(HttpStatus.OK).body(movieService.addCast(addCastRequest.movieId(), addCastRequest.actorId()));
    }

    @GetMapping("/movies/{id}")
    ResponseEntity<Movie> getMovie(@PathVariable Long id) {

        Optional<Movie> optionalMovie = movieService.get(id);

        if (optionalMovie.isPresent()) {
            return ResponseEntity.ok(optionalMovie.get());
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    record AddCastRequest(@NotNull Long movieId, @NotNull(message = "actor id should not be null") Long actorId) {}


//    GET /movies/1
//    POST /movies
//    PUT /movies/1
//    PATCH /movies/1
//    DELETE /movies/1

}
