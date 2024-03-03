package com.ysoftech.learning.dvdproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Actor extends Person {

    @Id
    @Column(name = "actor_id")
    private Integer id;

    protected Actor() {}

    public Actor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Integer getId() {
        return id;
    }
}