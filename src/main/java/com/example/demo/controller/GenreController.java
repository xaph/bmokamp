package com.example.demo.controller;

import com.example.demo.entity.Genre;
import com.example.demo.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreRepository genreRepository;

    @GetMapping
    List<Genre> list() {
        return (List<Genre>) genreRepository.findAll();
    }

}
