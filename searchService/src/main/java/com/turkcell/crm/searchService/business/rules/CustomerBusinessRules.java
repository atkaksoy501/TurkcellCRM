package com.turkcell.crm.searchService.business.rules;

import com.turkcell.crm.core.core.exceptions.types.BusinessException;
import com.turkcell.crm.searchService.business.messages.Messages;
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
            throw new BusinessException(messageService.getMessage(Messages.IndividualCustomerErrors.NATIONALITY_ID_MUST_BE_11_DIGITS));
        }
    }

    public void validateCustomerId(String customerId) {
        if (!customerId.matches("\\d{1,7}")) {
            throw new BusinessException(messageService.getMessage(Messages.IndividualCustomerErrors.CUSTOMER_ID_MUST_BETWEEN_1_AND_7_DIGITS));
        }
    }

    public void validateAccountNumber(String accountNumber) {
        if (accountNumber.length() != 8) {
            throw new BusinessException(messageService.getMessage(Messages.IndividualCustomerErrors.ACCOUNT_NUMBER_MUST_BE_8_DIGITS));
        }
    }

    public void validateMobilePhoneNumber(String mobilePhoneNumber) {
        if (mobilePhoneNumber.length() != 11) {
            throw new BusinessException(messageService.getMessage(Messages.IndividualCustomerErrors.GSM_NUMBER_MUST_BE_11_DIGITS));
        }
    }

    public void validateOrderNumber(String orderNumber) {
        if (orderNumber.length() != 8) {
            throw new BusinessException(messageService.getMessage(Messages.IndividualCustomerErrors.ORDER_NUMBER_MUST_BE_8_DIGITS));
        }
    }

    public void checkCustomerFound(boolean isFound) {
        if (!isFound) {
            throw new BusinessException(messageService.getMessage(Messages.IndividualCustomerErrors.CUSTOMER_NOT_FOUND));
        }
    }
}
