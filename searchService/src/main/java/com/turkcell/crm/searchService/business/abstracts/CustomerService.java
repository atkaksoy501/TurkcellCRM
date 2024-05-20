package com.turkcell.crm.searchService.business.abstracts;

import com.turkcell.crm.searchService.entities.concretes.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void add(Customer customer);
    void searchByNationalityId(String nationalityId);

    List<Customer> searchCustomers(
            Optional<String> nationalityId,
            Optional<Long> customerId,
            Optional<Long> accountNumber,
            Optional<Long> gsmNumber,
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<Long> orderNumber);
}
