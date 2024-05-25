package com.turkcell.crm.customerService.business.dtos.requests.Customer;

import com.turkcell.crm.customerService.entities.concretes.enums.Gender;
import com.turkcell.crm.customerService.entities.concretes.Address;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String firstName;

    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String middleName;

    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Za-z0-9]+$")
    private String lastName;

    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$")
    private LocalDate birthDate;

    @Pattern(regexp = "^(Male|Female)$")
    private Gender gender;

    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String fatherName;

    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String motherName;

    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String motherMaidenName;

    @Size(min = 11, max = 11)
    @Pattern(regexp = "^[1-9][0-9]{10}$")
    private String nationalityNumber;

    private List<Address> addresses;

//    private List<Account> accounts;

    @Size(min = 11, max = 11)
    @Pattern(regexp = "^[0-9]+$")
    private String mobilePhoneNumber;

    @Size(min = 11, max = 11)
    @Pattern(regexp = "^[0-9]+$")
    private String homePhoneNumber;
}
