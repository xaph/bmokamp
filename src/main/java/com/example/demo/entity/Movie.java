package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String imdbKey;

    @Column(name = "movie_year")
    private int year;

    private int duration;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany
    private Set<Actor> cast;

}
