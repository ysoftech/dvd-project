package com.ysoftech.learning.dvdproject.service;

import com.ysoftech.learning.dvdproject.entity.Address;
import com.ysoftech.learning.dvdproject.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddress() {
        return addressRepository.findAllAddresses();
    }
}
