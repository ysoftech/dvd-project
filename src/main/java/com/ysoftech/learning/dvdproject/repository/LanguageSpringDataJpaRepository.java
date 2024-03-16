package com.ysoftech.learning.dvdproject.repository;

import com.ysoftech.learning.dvdproject.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageSpringDataJpaRepository extends JpaRepository<Language, Integer> {
}
