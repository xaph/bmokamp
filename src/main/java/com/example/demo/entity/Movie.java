package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String imdbKey;

    @Column(name = "movie_year")
    private int year;

    private int duration;

    public Movie() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImdbKey() {
        return imdbKey;
    }

    public void setImdbKey(String imdbKey) {
        this.imdbKey = imdbKey;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
