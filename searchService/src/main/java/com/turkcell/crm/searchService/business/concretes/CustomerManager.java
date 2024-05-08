package com.turkcell.crm.searchService.business.concretes;

import com.turkcell.crm.searchService.business.abstracts.CustomerService;
import com.turkcell.crm.searchService.dataAccess.abstracts.CustomerRepository;
import com.turkcell.crm.searchService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void searchByNationalityId(String nationalityId) {
        customerRepository.findByNationalityId(nationalityId);
    }
}
