package com.turkcell.crm.customerService.business.dtos.requests.Customer;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateIndividualCustomerRequest {
    @NotEmpty
    @Size(min = 2, max = 30)
    private String firstName;

    @Email
    @NotEmpty
    @Size(min = 2, max = 30)
    private String email;

    @Size(min = 2, max = 30)
    private String middleName;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String lastName;

    @NotEmpty
    private LocalDate birthDate;

//    private Gender gender; //todo: enum tablosu olacak

    @NotEmpty
    @Size(min = 2, max = 30)
    private String fatherName;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String motherName;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String motherMaidenName;

    @Size(min = 11, max = 11)
    @Pattern(regexp = "^[0-9]{11}$")
    private String nationalityNumber;

//    private List<Integer> address_ids; //todo: address tablosu ile bağlantısı sağlanacak manager tarafında

    @NotEmpty
    @Size(min = 11, max = 11)
    private String mobilePhoneNumber;

    @NotEmpty
    @Size(min = 11, max = 11)
    private String homePhoneNumber;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String password;
}
