package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
class HelloController {

//    GET /listMovies
//    POST /createMovie
//    GET /getMovie
//    POST /deleteMovie
//
//
//
//    GET /movies
//    GET /movies/lord-of-the-rings
//    POST /movies
//    PUT /movies/lord-of-the-rings
//    DELETE /movies/lord-of-the-rings


    @GetMapping("/")
    String index() {
        return "helloo";
    }
}