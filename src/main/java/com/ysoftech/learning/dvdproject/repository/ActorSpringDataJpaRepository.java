package com.ysoftech.learning.dvdproject.repository;

import com.ysoftech.learning.dvdproject.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorSpringDataJpaRepository extends JpaRepository<Actor, Integer> {
}
