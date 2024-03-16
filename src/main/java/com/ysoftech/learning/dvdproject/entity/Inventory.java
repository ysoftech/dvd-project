package com.ysoftech.learning.dvdproject.entity;

import javax.persistence.*;

//@Entity
public class Inventory extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "inventory_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @Column(name = "store_id", nullable = false)
    private Integer storeId;


    protected Inventory() {}

    public Inventory(Film film, Integer storeId) {
        this.film = film;
        this.storeId = storeId;
    }

    public Integer getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}