package com.turkcell.crm.customerService.business.abstracts;


import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.CreatedCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetAllCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetCustomerResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.UpdatedCustomerResponse;

import java.util.List;

public interface CustomerService {
    CreatedCustomerResponse add(CreateCustomerRequest customerRequest);
    List<GetAllCustomerResponse> getAll();
    GetCustomerResponseById getById(int id);
    UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest);
    void delete(int id);

}
