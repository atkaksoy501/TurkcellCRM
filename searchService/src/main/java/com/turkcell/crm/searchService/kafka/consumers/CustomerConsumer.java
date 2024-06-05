package com.turkcell.crm.searchService.kafka.consumers;

import com.turkcell.crm.common.events.customer.CreateIndividualCustomerEvent;
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

    @KafkaListener(topics = "individual-customer-created", groupId="individual-customer-create")
    public void consume(CreateIndividualCustomerEvent customerCreatedEvent){
        LOGGER.info("Customer event consumed => {}", customerCreatedEvent);
        Customer customer = new Customer();
        customer.setCustomerId(customerCreatedEvent.getId());
        customer.setEmail(customerCreatedEvent.getEmail());
        customer.setFirstName(customerCreatedEvent.getFirstName());
        customer.setMiddleName(customerCreatedEvent.getMiddleName());
        customer.setLastName(customerCreatedEvent.getLastName());
        customer.setNationalityId(customerCreatedEvent.getNationalityNumber());
        customer.setMobilePhoneNumber(customerCreatedEvent.getMobilePhoneNumber());
        customer.setAccountNumbers(customerCreatedEvent.getAccountNumbers());
        customer.setOrderNumber(customerCreatedEvent.getOrderNumber());
        this.customerService.add(customer);
    }
}
