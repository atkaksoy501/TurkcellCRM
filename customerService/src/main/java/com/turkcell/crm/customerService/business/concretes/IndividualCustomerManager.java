package com.turkcell.crm.customerService.business.concretes;

import com.turkcell.crm.common.events.identity.CreateIndividualCustomerEvent;
import com.turkcell.crm.customerService.business.abstracts.IndividualCustomerService;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.CreatedIndividualCustomerResponse;
import com.turkcell.crm.customerService.business.rules.IndividualCustomerBusinessRules;
import com.turkcell.crm.customerService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.customerService.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.crm.customerService.entities.concretes.IndividualCustomer;
import com.turkcell.crm.customerService.kafka.producers.IndividualCustomerProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class IndividualCustomerManager implements IndividualCustomerService {
    private final ModelMapperService modelMapperService;
    private final IndividualCustomerRepository individualCustomerRepository;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private final IndividualCustomerProducer individualCustomerProducer;

    @Override
    public CreatedIndividualCustomerResponse save(CreateIndividualCustomerRequest individualCustomer) {
//        individualCustomerBusinessRules.individualCustomerAlreadyExists(individualCustomer.getNationalityId());
        IndividualCustomer customer = new IndividualCustomer();
        customer.setFirstName(individualCustomer.getFirstName());
        customer.setEmail(individualCustomer.getEmail());
        customer.setMiddleName(individualCustomer.getMiddleName());
        customer.setLastName(individualCustomer.getLastName());
        customer.setBirthDate(individualCustomer.getBirthDate());
        customer.setFatherName(individualCustomer.getFatherName());
        customer.setMotherName(individualCustomer.getMotherName());
        customer.setMotherMaidenName(individualCustomer.getMotherMaidenName());
        customer.setNationalityId(individualCustomer.getNationalityId());
        customer.setMobilePhoneNumber(individualCustomer.getMobilePhoneNumber());
        customer.setHomePhoneNumber(individualCustomer.getHomePhoneNumber());

        IndividualCustomer savedCustomer = individualCustomerRepository.save(customer);
        CreatedIndividualCustomerResponse response = modelMapperService.forResponse().map(savedCustomer, CreatedIndividualCustomerResponse.class);

        CreateIndividualCustomerEvent event = new CreateIndividualCustomerEvent();
        event.setId(savedCustomer.getId());
        event.setFirstName(individualCustomer.getFirstName());
        event.setLastName(individualCustomer.getLastName());
        event.setNationalityId(individualCustomer.getNationalityId());
        event.setEmail(individualCustomer.getEmail());
        event.setMobilePhoneNumber(individualCustomer.getMobilePhoneNumber());
        event.setAccountNumber("1");
        event.setOrderNumber("1");


        individualCustomerProducer.sendMessage(event);

        return response;
    }

    @Override
    public IndividualCustomer update(UpdateIndividualCustomerRequest individualCustomer) {
        return null;
    }

    @Override
    public void delete(IndividualCustomer individualCustomer) {

    }

    @Override
    public IndividualCustomer getById(int id) {
        return null;
    }

    @Override
    public List<IndividualCustomer> getAll() {
        return null;
    }
}
