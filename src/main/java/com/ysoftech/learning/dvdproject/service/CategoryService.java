package com.ysoftech.learning.dvdproject.service;

import com.ysoftech.learning.dvdproject.entity.Category;
import com.ysoftech.learning.dvdproject.repository.CategorySpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private final CategorySpringDataJpaRepository categorySpringDataJpaRepository;

    public CategoryService(CategorySpringDataJpaRepository categorySpringDataJpaRepository) {
        this.categorySpringDataJpaRepository = categorySpringDataJpaRepository;
    }

    public List<Category> getAllCategories() {
        return categorySpringDataJpaRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        if(id == null)
            throw new IllegalStateException("Id to get Category can not be null");
        return categorySpringDataJpaRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}