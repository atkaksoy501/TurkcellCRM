package com.turkcell.crm.customerService.business.concretes;

import com.turkcell.crm.customerService.abstracts.CustomerRepository;
import com.turkcell.crm.customerService.business.abstracts.CustomerService;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.CreatedCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetAllCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetCustomerResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.UpdatedCustomerResponse;
import com.turkcell.crm.customerService.business.rules.CustomerBusinessRules;
import com.turkcell.crm.customerService.concretes.Customer;
import com.turkcell.crm.customerService.core.utilities.mapping.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private CustomerBusinessRules customerBusinessRules;

    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) {
        customerBusinessRules.customerNameCannotBeDuplicated(createCustomerRequest.getName());
        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        customer.setCreateDate(LocalDateTime.now());

        Customer savedCustomer = customerRepository.save(customer);

        CreatedCustomerResponse createdCustomerResponse =
                this.modelMapperService.forResponse().map(savedCustomer, CreatedCustomerResponse.class);

        return createdCustomerResponse;
    }

    @Override
    public List<GetAllCustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomerResponse> getCustomerResponseList = new ArrayList<>();
        for (Customer customer : customers) {
            GetAllCustomerResponse getCustomerResponse = this.modelMapperService.forResponse().map(customer, GetAllCustomerResponse.class);
            getCustomerResponseList.add(getCustomerResponse);
        }
        return getCustomerResponseList;
    }

    @Override
    public GetCustomerResponseById getById(int id) {
        customerBusinessRules.customerMustExists(id);
        Customer customer = customerRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(customer, GetCustomerResponseById.class);
    }

    @Override
    public UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest) {
        customerBusinessRules.customerMustExists(updateCustomerRequest.getId());
        Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        customer.setUpdateDate(LocalDateTime.now());
        Customer updatedCustomer = customerRepository.save(customer);
        UpdatedCustomerResponse updatedCustomerResponse = this.modelMapperService.forResponse().map(updatedCustomer, UpdatedCustomerResponse.class);
        updatedCustomerResponse.setUpdateDate(updatedCustomer.getUpdateDate());
        return updatedCustomerResponse;
    }

    @Override
    public void delete(int id) {
        customerBusinessRules.customerMustExists(id);
        customerRepository.deleteById(id);
    }
}
