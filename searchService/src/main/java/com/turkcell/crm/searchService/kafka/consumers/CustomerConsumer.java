package com.turkcell.crm.searchService.kafka.consumers;

import com.turkcell.crm.common.events.identity.CreateCustomerRequest;
import com.turkcell.crm.searchService.business.abstracts.CustomerService;
import com.turkcell.crm.searchService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerConsumer.class);
    private CustomerService customerService;
    @KafkaListener(topics = "customer-created",groupId="customer-create")
    public void consume(CreateCustomerRequest customerCreatedEvent){//hata var
        Customer customer = new Customer();
        customer.setFirstName(customerCreatedEvent.getFirstName());
        customer.setMiddleName(customerCreatedEvent.getMiddleName());
        customer.setLastName(customerCreatedEvent.getLastName());
        customer.setEmail(customerCreatedEvent.getEmail());
        customer.setBirthDate(customerCreatedEvent.getBirthDate());
        customer.setFatherName(customerCreatedEvent.getFatherName());
        customer.setHomePhoneNumber(customerCreatedEvent.getHomePhoneNumber());
        customer.setMobilePhoneNumber(customerCreatedEvent.getMobilePhoneNumber());
        customer.setMotherMaidenName(customerCreatedEvent.getMotherMaidenName());
        customer.setNationalId(customerCreatedEvent.getNationalId());
        customer.setActive(customerCreatedEvent.getActive());
        customer.setMotherName(customerCreatedEvent.getMotherName());
        customer.setId(customerCreatedEvent.getId());
        this.customerService.add(customer);
    }
}
