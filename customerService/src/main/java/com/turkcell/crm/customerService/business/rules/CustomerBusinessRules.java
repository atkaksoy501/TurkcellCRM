package com.turkcell.crm.customerService.business.rules;

import com.turkcell.crm.customerService.abstracts.CustomerRepository;
import com.turkcell.crm.customerService.business.messages.Messages;
import com.turkcell.crm.customerService.concretes.Customer;
import com.turkcell.crm.customerService.core.business.abstracts.MessageService;
import com.turkcell.crm.customerService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    CustomerRepository customerRepository;
    MessageService messageService;

    public void customerNameCannotBeDuplicated(String customerName) {
        Optional<Customer> customer = customerRepository.findByNameIgnoreCase(customerName);
        if (customer.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.CustomerErrors.CUSTOMER_NAME_EXISTS));
        }
    }

    public void customerMustExists(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()) {
            throw new BusinessException("CustomerNotExists");
        }
    }
}
