package com.turkcell.crm.searchService.dataAccess.abstracts;

import com.turkcell.crm.searchService.entities.concretes.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Integer> {
}
