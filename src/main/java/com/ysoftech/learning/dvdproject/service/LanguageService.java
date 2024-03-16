package com.ysoftech.learning.dvdproject.service;

import com.ysoftech.learning.dvdproject.entity.Language;
import com.ysoftech.learning.dvdproject.repository.LanguageSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LanguageService {
    @Autowired
    private final LanguageSpringDataJpaRepository languageSpringDataJpaRepository;

    public LanguageService(LanguageSpringDataJpaRepository languageSpringDataJpaRepository) {
        this.languageSpringDataJpaRepository = languageSpringDataJpaRepository;
    }

    public List<Language> getAllLanguages() {
        return languageSpringDataJpaRepository.findAll();
    }

    public Language getLanguageById(Integer id) {
        if(id == null)
            throw new IllegalStateException("Id to get Language can not be null");
        return languageSpringDataJpaRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}