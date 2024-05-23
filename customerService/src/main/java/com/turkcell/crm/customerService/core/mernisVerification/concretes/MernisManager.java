package com.turkcell.crm.customerService.core.mernisVerification.concretes;


import com.turkcell.crm.customerService.core.mernisVerification.abstracts.MernisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class MernisManager implements MernisService {
    @Override
    public boolean validateCitizen(String nationalityNumber, String firstName, String lastName, LocalDate birthDate) {
        return true; //todo: implement
    }
}
