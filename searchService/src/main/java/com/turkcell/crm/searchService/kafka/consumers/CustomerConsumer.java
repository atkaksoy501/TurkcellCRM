package com.turkcell.crm.searchService.kafka.consumers;

import com.turkcell.crm.common.events.identity.CreateIndividualCustomerEvent;
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
    @KafkaListener(topics = "individual-customer-created",groupId="individual-customer-create")
    public void consume(CreateIndividualCustomerEvent customerCreatedEvent){
        Customer customer = new Customer();
        customer.setId(customerCreatedEvent.getId());
        customer.setEmail(customerCreatedEvent.getEmail());
        customer.setFirstName(customerCreatedEvent.getFirstName());
        customer.setLastName(customerCreatedEvent.getLastName());
        customer.setNationalityId(customerCreatedEvent.getNationalityId());
        customer.setMobilePhoneNumber(customerCreatedEvent.getMobilePhoneNumber());
        customer.setAccountNumber(customerCreatedEvent.getAccountNumber());
        customer.setOrderNumber(customerCreatedEvent.getOrderNumber());
        this.customerService.add(customer);
    }
}
