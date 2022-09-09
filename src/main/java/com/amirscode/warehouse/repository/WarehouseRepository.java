package com.amirscode.warehouse.repository;

import com.amirscode.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "warehouse")
public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
}
