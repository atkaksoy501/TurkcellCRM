package com.turkcell.crm.searchService.business.abstracts;

import com.turkcell.crm.searchService.entities.concretes.Customer;

public interface CustomerService {
    void add(Customer customer);
    void searchByNationalityId(String nationalityId);
}
