package com.amirscode.warehouse.repository;

import com.amirscode.warehouse.entity.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "inputProduct")
public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
}
