package com.ysoftech.learning.dvdproject.repository;

import com.ysoftech.learning.dvdproject.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}