package com.turkcell.crm.customerService.business.concretes;

import com.turkcell.crm.customerService.dataAccess.abstracts.CustomerRepository;
import com.turkcell.crm.customerService.business.abstracts.CustomerService;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.CreatedCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetAllCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetCustomerResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.UpdatedCustomerResponse;
import com.turkcell.crm.customerService.business.rules.CustomerBusinessRules;
import com.turkcell.crm.customerService.entities.concretes.Customer;
import com.turkcell.crm.customerService.core.utilities.mapping.ModelMapperService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private CustomerBusinessRules customerBusinessRules;
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) {
        customerBusinessRules.customerNameCannotBeDuplicated(createCustomerRequest.getFirstName()); //todo: isme göre değil, kimlik no'ya göre olsun
        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        customer.setCreatedDate(LocalDateTime.now());

        Customer savedCustomer = customerRepository.save(customer);

        CreatedCustomerResponse createdCustomerResponse =
                this.modelMapperService.forResponse().map(savedCustomer, CreatedCustomerResponse.class);
        Message<CreateCustomerRequest> message = MessageBuilder.withPayload(createCustomerRequest)
                .setHeader(KafkaHeaders.TOPIC,"customertopic")
                .build();
        kafkaTemplate.send(message);
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
        customer.setUpdatedDate(LocalDateTime.now());
        Customer updatedCustomer = customerRepository.save(customer);
        UpdatedCustomerResponse updatedCustomerResponse = this.modelMapperService.forResponse().map(updatedCustomer, UpdatedCustomerResponse.class);
        updatedCustomerResponse.setUpdatedDate(updatedCustomer.getUpdatedDate());
        return updatedCustomerResponse;
    }

    @Override
    public void delete(int id) {
        customerBusinessRules.customerMustExists(id);
        customerRepository.deleteById(id);
    }
}
