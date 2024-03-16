package com.ysoftech.learning.dvdproject.service;

import com.ysoftech.learning.dvdproject.entity.Actor;
import com.ysoftech.learning.dvdproject.repository.ActorSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActorService {

    @Autowired
    private final ActorSpringDataJpaRepository actorSpringDataJpaRepository;

    public ActorService(ActorSpringDataJpaRepository actorSpringDataJpaRepository) {
        this.actorSpringDataJpaRepository = actorSpringDataJpaRepository;
    }

    public List<Actor> getAllActors() {
        return actorSpringDataJpaRepository.findAll();
    }

    public Actor getActorById(Integer id) {
        if(id == null)
            throw new RuntimeException("ID Can not be null");
        return actorSpringDataJpaRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
