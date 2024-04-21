package com.turkcell.crm.customerService.abstracts;


import com.turkcell.crm.customerService.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByNameIgnoreCase(String customerName);
}