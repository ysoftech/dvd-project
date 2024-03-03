package com.ysoftech.learning.dvdproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="address")
public class Address extends BaseEntity {

    @Id
    @Column(name = "address_id")
    private Integer id;

    @Column(length = 50)
    private String address;

    @Column(length = 50)
    private String address2;

    @Column(length = 20)
    private String district;

    // Mapping for city required. To be inserted here
    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonManagedReference
    private City city;

    @OneToMany(mappedBy = "address")
    @JsonBackReference
    private List<Customer> customers = new ArrayList<>();

    @Column(name="postal_code", length = 10)
    private String postalCode;

    @Column(length = 20)
    private String phone;

    protected Address() {}

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        this.getCustomers().add(customer);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}