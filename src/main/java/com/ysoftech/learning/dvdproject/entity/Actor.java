package com.ysoftech.learning.dvdproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Actor extends Person {

    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private Integer id;

    @ManyToMany(mappedBy = "actors")
    private List<Film> films = new ArrayList<>();

    protected Actor() {}
    public Actor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Integer getId() {
        return id;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film) {
        this.getFilms().add(film);
    }
}