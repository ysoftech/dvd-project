package com.ysoftech.learning.dvdproject.repository;

import com.ysoftech.learning.dvdproject.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmSpringDataJpaRepository extends JpaRepository<Film, Integer> {

}