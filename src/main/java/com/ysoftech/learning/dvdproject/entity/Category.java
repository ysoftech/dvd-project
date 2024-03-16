package com.ysoftech.learning.dvdproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Integer id;

    private String name;

    protected Category() {}

    public Category(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}