package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name should not be blank!!!")
    private String name;

    private String imdbKey;

    @Column(name = "movie_year")
    private int year;

    private int duration;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany//(fetch = FetchType.EAGER)
    private Set<Actor> cast = new HashSet<>();

}
