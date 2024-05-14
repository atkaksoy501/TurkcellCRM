package com.turkcell.crm.customerService.business.rules;

import com.turkcell.crm.customerService.business.messages.Messages;
import com.turkcell.crm.customerService.core.business.abstracts.MessageService;
import com.turkcell.crm.customerService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.crm.customerService.dataAccess.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final MessageService messageService;

    public void individualCustomerAlreadyExists(String nationalNumber) {
        if (individualCustomerRepository.existsByNationalityNumber(nationalNumber)) {
            throw new BusinessException(messageService.getMessage(Messages.IndividualCustomerErrors.CUSTOMER_ALREADY_EXISTS));
        }
    }
}
