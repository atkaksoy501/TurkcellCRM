package com.turkcell.crm.searchService.business.concretes;

import com.turkcell.crm.searchService.business.abstracts.CustomerService;
import com.turkcell.crm.searchService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    @Override
    public void add(Customer customer) {
        //todo: implement
    }
}
