package com.turkcell.crm.customerService.core.mernisVerification.abstracts;

import java.time.LocalDate;

public interface MernisService {
    boolean validateCitizen(String nationalityNumber, String firstName, String lastName, LocalDate birthDate);
}
