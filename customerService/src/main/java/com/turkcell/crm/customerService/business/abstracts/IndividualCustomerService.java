package com.turkcell.crm.customerService.business.abstracts;

import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.CreatedIndividualCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetAllIndividualCustomersResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetIndividualCustomerResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.UpdatedIndividualCustomerResponse;
import com.turkcell.crm.customerService.entities.concretes.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse save(CreateIndividualCustomerRequest individualCustomer);
    UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest individualCustomer);
    void delete(int id);
    GetIndividualCustomerResponseById getById(int id);
    List<GetAllIndividualCustomersResponse> getAll();
}
