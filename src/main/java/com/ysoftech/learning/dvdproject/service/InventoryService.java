package com.ysoftech.learning.dvdproject.service;

import com.ysoftech.learning.dvdproject.entity.Inventory;
import com.ysoftech.learning.dvdproject.repository.InventorySpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryService {

    @Autowired
    private final InventorySpringDataJpaRepository inventorySpringDataJpaRepository;

    public InventoryService(InventorySpringDataJpaRepository inventorySpringDataJpaRepository) {
        this.inventorySpringDataJpaRepository = inventorySpringDataJpaRepository;
    }

    public List<Inventory> getAllInventories() {
        return inventorySpringDataJpaRepository.findAll();
    }

    public Inventory getInventoryById(Integer id) {
        if(id == null)
            throw new RuntimeException("ID Can not be null");
        return inventorySpringDataJpaRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
