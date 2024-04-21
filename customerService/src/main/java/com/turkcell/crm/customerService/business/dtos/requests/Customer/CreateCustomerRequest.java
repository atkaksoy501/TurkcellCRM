package com.turkcell.crm.customerService.business.dtos.requests.Customer;

import com.turkcell.crm.customerService.core.enums.Gender;
import com.turkcell.crm.customerService.entities.concretes.Account;
import com.turkcell.crm.customerService.entities.concretes.Address;
import com.turkcell.crm.customerService.entities.concretes.Contact;
import jakarta.persistence.*;
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
public class CreateCustomerRequest {
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @Size(min = 2, max = 30)
    private String middleName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private Gender gender;

    @NotNull
    @Size(min = 2, max = 30)
    private String fatherName;

    @NotNull
    @Size(min = 2, max = 30)
    private String motherName;

    @NotNull
    @Size(min = 2, max = 30)
    private String motherMaidenName;

    @NotNull
    @Size(min = 11, max = 11)
    private String nationalId;

    @NotNull
    private List<Address> addresses;

    @NotNull
    private Contact contactInfo;
}
