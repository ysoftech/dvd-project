package com.ysoftech.learning.dvdproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Customer extends Person {

    @Id
    @Column(name = "customer_id")
    private Integer id;

    // Store Id association. To be added here.

    @Column(length = 50)
    private String email;

    // Address Id association. To be added here. Done :)
    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonManagedReference
    private Address address;

    @Column(name = "activebool")
    private Boolean activeBool;

    @Column(name="create_date")
    private LocalDate createdDate;

    private Integer active;

    private Customer() {}

    public Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getActiveBool() {
        return activeBool;
    }

    public void setActiveBool(Boolean activeBool) {
        this.activeBool = activeBool;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}