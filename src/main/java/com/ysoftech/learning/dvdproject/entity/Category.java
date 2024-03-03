package com.ysoftech.learning.dvdproject.entity;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category extends BaseEntity {

    @Id
    @Column(name = "category_id")
    private Integer id;

    @Column(length = 25)
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
