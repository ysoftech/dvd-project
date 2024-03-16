package com.ysoftech.learning.dvdproject.repository;

import com.ysoftech.learning.dvdproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorySpringDataJpaRepository extends JpaRepository<Category, Integer> {
}
