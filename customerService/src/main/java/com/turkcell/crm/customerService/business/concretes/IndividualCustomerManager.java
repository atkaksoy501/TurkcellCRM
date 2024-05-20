package com.turkcell.crm.customerService.business.concretes;

import com.turkcell.crm.common.events.customer.CreateIndividualCustomerEvent;
import com.turkcell.crm.common.events.identity.CreateCustomerIdentityEvent;
import com.turkcell.crm.customerService.business.abstracts.IndividualCustomerService;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.CreatedIndividualCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetAllIndividualCustomersResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetIndividualCustomerResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.UpdatedIndividualCustomerResponse;
import com.turkcell.crm.customerService.business.rules.IndividualCustomerBusinessRules;
import com.turkcell.crm.customerService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.customerService.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.crm.customerService.entities.concretes.IndividualCustomer;
import com.turkcell.crm.customerService.kafka.producers.IndividualCustomerIdentityProducer;
import com.turkcell.crm.customerService.kafka.producers.IndividualCustomerProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class IndividualCustomerManager implements IndividualCustomerService {
    private final ModelMapperService modelMapperService;
    private final IndividualCustomerRepository individualCustomerRepository;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private final IndividualCustomerProducer individualCustomerProducer;
    private final IndividualCustomerIdentityProducer individualCustomerIdentityProducer;

    @Override
    @Transactional
    public CreatedIndividualCustomerResponse save(CreateIndividualCustomerRequest individualCustomer) {

        individualCustomerBusinessRules.individualCustomerMustBeUnique(individualCustomer.getNationalityNumber());
        IndividualCustomer customer = modelMapperService.forRequest().map(individualCustomer, IndividualCustomer.class);
        customer.setCreatedDate(LocalDateTime.now());

        IndividualCustomer savedCustomer = individualCustomerRepository.save(customer);

        CreatedIndividualCustomerResponse response = modelMapperService.forResponse().map(savedCustomer, CreatedIndividualCustomerResponse.class);

        CreateIndividualCustomerEvent event = modelMapperService.forRequest().map(response, CreateIndividualCustomerEvent.class);
        event.setAccountNumbers(customer.getAddresses().stream().map(address -> address.getId().toString()).toList());
//        event.setOrderNumber("1"); //todo: ???

        CreateCustomerIdentityEvent identityEvent = new CreateCustomerIdentityEvent();
        identityEvent.setEmail(individualCustomer.getEmail());
        identityEvent.setPassword(individualCustomer.getPassword());


        individualCustomerProducer.sendMessage(event);
        individualCustomerIdentityProducer.sendMessage(identityEvent);

        return response;
    }

    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest individualCustomer) {
        individualCustomerBusinessRules.individualCustomerMustExists(individualCustomer.getId());
        IndividualCustomer customer = individualCustomerRepository.findById(individualCustomer.getId()).orElse(null);
        modelMapperService.forUpdate().map(individualCustomer, customer);
        customer.setUpdatedDate(LocalDateTime.now());
        IndividualCustomer savedCustomer = individualCustomerRepository.save(customer);
        return modelMapperService.forResponse().map(savedCustomer, UpdatedIndividualCustomerResponse.class);
    }

    @Override
    public void delete(int id) {
        individualCustomerBusinessRules.individualCustomerMustExists(id);
        IndividualCustomer customer = individualCustomerRepository.findById(id).orElse(null);
        customer.setActive(false);
        customer.setDeletedDate(LocalDateTime.now());
        individualCustomerRepository.save(customer);
    }

    @Override
    public GetIndividualCustomerResponseById getById(int id) {
        individualCustomerBusinessRules.individualCustomerMustExists(id);
        IndividualCustomer customer = individualCustomerRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(customer, GetIndividualCustomerResponseById.class);
    }

    @Override
    public List<GetAllIndividualCustomersResponse> getAll() {
        List<IndividualCustomer> customers = individualCustomerRepository.findAll();
        return customers.stream()
                .map(customer -> modelMapperService.forResponse().map(customer, GetAllIndividualCustomersResponse.class))
                .toList();
    }
}
