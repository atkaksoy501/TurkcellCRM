package com.turkcell.crm.customerService.business.dtos.requests.Customer;

import com.turkcell.crm.customerService.core.enums.Gender;
import com.turkcell.crm.customerService.entities.concretes.Account;
import com.turkcell.crm.customerService.entities.concretes.Address;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateIndividualCustomerRequest {
    @NotNull
    private int id;

    @Size(min = 2, max = 30)
    private String firstName;

    @Size(min = 2, max = 30)
    private String middleName;

    @Size(min = 2, max = 30)
    private String lastName;

    private LocalDate birthDate;

    private Gender gender;

    @Size(min = 2, max = 30)
    private String fatherName;

    @Size(min = 2, max = 30)
    private String motherName;

    @Size(min = 2, max = 30)
    private String motherMaidenName;

    @Size(min = 11, max = 11)
    private String nationalId;

    private List<Address> addresses;

    private List<Account> accounts;

    @Size(min = 11, max = 11)
    private String mobilePhoneNumber;

    @Size(min = 11, max = 11)
    private String homePhoneNumber;
}
