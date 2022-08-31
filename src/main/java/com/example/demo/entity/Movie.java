package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;

    private String imdbKey;

    private int year;

    private int duration;

    public Movie() {
    }

    public Movie(Long id, String name, String imdbKey, int year, int duration) {
        this.id = id;
        this.name = name;
        this.imdbKey = imdbKey;
        this.year = year;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
