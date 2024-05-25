package com.turkcell.crm.customerService.business.rules;

import com.turkcell.crm.customerService.business.messages.Messages;
import com.turkcell.crm.customerService.core.business.abstracts.MessageService;
import com.turkcell.crm.customerService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.crm.customerService.core.mernisVerification.abstracts.MernisService;
import com.turkcell.crm.customerService.dataAccess.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final MessageService messageService;
    private final MernisService mernisService;

    public void individualCustomerMustBeUnique(String nationalNumber) {
        if (individualCustomerRepository.existsByNationalityNumber(nationalNumber)) {
            throw new BusinessException(messageService.getMessage(Messages.IndividualCustomerErrors.CUSTOMER_ALREADY_EXISTS));
        }
    }

    public void individualCustomerMustExists(int id) {
        if (!individualCustomerRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.IndividualCustomerErrors.CUSTOMER_NOT_FOUND));
        }
    }
    public void validateCitizen(String nationalityNumber, String firstName, String lastName, LocalDate birthDate) {
        boolean isValid = mernisService.validateCitizen(nationalityNumber, firstName, lastName, birthDate);
        if (!isValid) {
            throw new BusinessException(messageService.getMessage(Messages.IndividualCustomerErrors.CITIZEN_NOT_FOUND));
        }
    }
}
