package com.ysoftech.learning.dvdproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class City extends BaseEntity {

    @Id
    @Column(name = "city_id")
    private Integer id;

    @Column(length = 50)
    private String city;

    @OneToMany(mappedBy = "city")
    @JsonBackReference
    private List<Address> addressList = new ArrayList<>();

    // Country_id association needs to map. To be add here.
    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonManagedReference
    private Country country;

    protected City() {}

    public City(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void addAddress(Address address) {
        this.getAddressList().add(address);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}