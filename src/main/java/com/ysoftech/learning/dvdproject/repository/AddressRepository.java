package com.ysoftech.learning.dvdproject.repository;

import com.ysoftech.learning.dvdproject.entity.Address;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(value = "select a from Address a JOIN FETCH a.city")
    @EntityGraph(attributePaths = {"city.country", "customers"})
    List<Address> findAllAddresses();

}
