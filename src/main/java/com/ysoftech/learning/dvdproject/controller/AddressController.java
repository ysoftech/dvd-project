package com.ysoftech.learning.dvdproject.controller;

import com.ysoftech.learning.dvdproject.entity.Address;
import com.ysoftech.learning.dvdproject.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    @Transactional
    public ResponseEntity<List<Address>> getAddressList() {
      //  return new ResponseEntity<List<Address>>(addressService.getAllAddress(), HttpStatus.OK)
       //         .getBody();
        return ResponseEntity.ok(addressService.getAllAddress());
    }

}