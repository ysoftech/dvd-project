package com.ysoftech.learning.dvdproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country extends BaseEntity {
    @Id
    @Column(name = "country_id")
    private Integer id;

    @Column(length = 50)
    private String country;

    @OneToMany(mappedBy = "country")
    @JsonBackReference
    private List<City> cityList = new ArrayList<>();

    protected Country() {}

    public Country(String country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void addCity(City city) {
        this.getCityList().add(city);
    }
}
