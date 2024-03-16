package com.ysoftech.learning.dvdproject.service;

import com.ysoftech.learning.dvdproject.entity.Film;
import com.ysoftech.learning.dvdproject.repository.FilmSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FilmService {
    @Autowired
    private final FilmSpringDataJpaRepository filmSpringDataJpaRepository;

    public FilmService(FilmSpringDataJpaRepository filmSpringDataJpaRepository) {
        this.filmSpringDataJpaRepository = filmSpringDataJpaRepository;
    }

    public List<Film> getAllFilms() {
        return filmSpringDataJpaRepository.findAll();
    }

    public Film getFilmById(Integer id) {
        if(id == null)
            throw new IllegalArgumentException("Id to get film can not be null");
        return filmSpringDataJpaRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
