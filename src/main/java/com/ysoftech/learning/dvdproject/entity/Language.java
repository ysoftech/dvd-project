package com.ysoftech.learning.dvdproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Language extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "language_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "language")
    private List<Film> films = new ArrayList<>();

    protected Language() {}

    public Language(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film) {
        this.getFilms().add(film);
    }
}