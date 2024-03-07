package com.ysoftech.learning.dvdproject.service;

import com.ysoftech.learning.dvdproject.entity.Address;
import com.ysoftech.learning.dvdproject.querydsl.AddressQueryBuilder;
import com.ysoftech.learning.dvdproject.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressQueryBuilder addressQueryBuilder;

    public List<Address> getAllAddress() {
        // return addressRepository.findAllAddressesWithCitiesAndCountries();
        return addressQueryBuilder.findAllAddress().fetch();
    }

    public List<Address> getAddressByCity(String city) {
        return addressQueryBuilder.findAllAddressByCity(city).fetch();
    }
}
