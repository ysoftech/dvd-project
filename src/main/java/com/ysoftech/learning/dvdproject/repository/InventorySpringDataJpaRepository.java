package com.ysoftech.learning.dvdproject.repository;

import com.ysoftech.learning.dvdproject.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventorySpringDataJpaRepository extends JpaRepository<Inventory, Integer> {
}
