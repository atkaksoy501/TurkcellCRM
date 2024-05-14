package com.turkcell.crm.customerService.business.abstracts;


import com.turkcell.crm.common.events.customer.CreateCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.CreatedCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetAllIndividualCustomersResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetIndividualCustomerResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.UpdatedIndividualCustomerResponse;

import java.util.List;

public interface CustomerService {
    CreatedCustomerResponse add(CreateCustomerRequest customerRequest);
    List<GetAllIndividualCustomersResponse> getAll();
    GetIndividualCustomerResponseById getById(int id);
    UpdatedIndividualCustomerResponse updateIndividual(UpdateIndividualCustomerRequest updateCustomerRequest);
    void delete(int id);

}
