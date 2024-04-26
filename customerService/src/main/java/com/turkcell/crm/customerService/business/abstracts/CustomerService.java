package com.turkcell.crm.customerService.business.abstracts;


import com.turkcell.crm.common.events.identity.CreateCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.CreatedCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetAllCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetCustomerResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.UpdatedCustomerResponse;

import java.util.List;

public interface CustomerService {
    CreatedCustomerResponse add(CreateCustomerRequest customerRequest);
    List<GetAllCustomerResponse> getAll();
    GetCustomerResponseById getById(int id);
    UpdatedCustomerResponse updateIndividual(UpdateIndividualCustomerRequest updateCustomerRequest);
    void delete(int id);

}
