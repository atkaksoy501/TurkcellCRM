package com.turkcell.crm.searchService.business.rules;

import com.turkcell.crm.core.core.exceptions.types.BusinessException;
import com.turkcell.crm.searchService.core.business.abstracts.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Component
public class CustomerBusinessRules {

    private final MessageService messageService;

    public void validateNationalityId(String nationalityId) {
        if (!nationalityId.matches("\\d{11}")) {
            throw new BusinessException("Nationality ID must be a positive integer and 11 digits long.");
        }
    }

    public void validateCustomerId(String customerId) {
        if (!customerId.matches("\\d{1,7}")) {
            throw new BusinessException("Customer ID must be a positive integer and up to 7 digits long.");
        }
    }

    public void validateAccountNumber(Long accountNumber) {
        if (accountNumber < 0) {
            throw new BusinessException("Account Number must be a positive integer.");
        }
    }

    public void validateGsmNumber(Long gsmNumber) {
        if (String.valueOf(gsmNumber).length() != 11) {
            throw new BusinessException("GSM Number must be 11 digits long.");
        }
    }

    public void validateOrderNumber(Long orderNumber) {
        if (orderNumber < 0) {
            throw new BusinessException("Order Number must be a positive integer.");
        }
    }

    public void checkCustomerFound(boolean isFound) {
        if (!isFound) {
            throw new BusinessException("No customer found! Would you like to create the customer?");
        }
    }
}
