package com.ysoftech.learning.dvdproject.controller;

import com.ysoftech.learning.dvdproject.entity.Actor;
import com.ysoftech.learning.dvdproject.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {

    @Autowired
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actor/{id}")
    public ResponseEntity<Actor> getActor(@PathVariable Integer id) {
       // return new ResponseEntity<Actor>(actorService.findById(id), HttpStatus.OK);
       return ResponseEntity.ok(actorService.findById(id));
    }
}
