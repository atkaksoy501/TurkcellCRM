package com.turkcell.crm.catalogService.catalogService.dataAccess.abstracts;

import com.turkcell.crm.catalogService.catalogService.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
