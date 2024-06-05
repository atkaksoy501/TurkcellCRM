package com.turkcell.crm.searchService.dataAccess.abstracts;

import com.turkcell.crm.searchService.entities.concretes.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
