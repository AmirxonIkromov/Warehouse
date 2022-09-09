package com.amirscode.warehouse.repository;

import com.amirscode.warehouse.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "currency")
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
}
