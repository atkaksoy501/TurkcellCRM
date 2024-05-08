package com.turkcell.crm.customerService.business.abstracts;

import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.CreatedIndividualCustomerResponse;
import com.turkcell.crm.customerService.entities.concretes.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse save(CreateIndividualCustomerRequest individualCustomer);
    IndividualCustomer update(UpdateIndividualCustomerRequest individualCustomer);
    void delete(IndividualCustomer individualCustomer);
    IndividualCustomer getById(int id);
    List<IndividualCustomer> getAll();
}
