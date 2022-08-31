package com.example.demo.controller;

import com.example.demo.Hello;
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


    //{
    //    "id": 1,
    //    "content": "Hello, World!"
    //}

    @GetMapping("/")
    Hello index() {

//        Long id = 1l;
//        String content = "{ \"id\": 1, \"content\": \"Hello, World!\" }";

        Hello hello = new Hello(1l, "Hello, World from object!");

        return hello;
    }







}