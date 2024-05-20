package com.turkcell.crm.customerService.business.dtos.requests.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateIndividualCustomerRequest {
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @Email
    @NotNull
    @Size(min = 2, max = 30)
    private String email;

    @Size(min = 2, max = 30)
    private String middleName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

//    @NotNull
    private LocalDate birthDate;

//    private Gender gender; //todo: enum tablosu olacak

//    @NotNull
    @Size(min = 2, max = 30)
    private String fatherName;

//    @NotNull
    @Size(min = 2, max = 30)
    private String motherName;

//    @NotNull
    @Size(min = 2, max = 30)
    private String motherMaidenName;

    @Size(min = 11, max = 11)
    @Pattern(regexp = "^[0-9]{11}$")
    private String nationalityNumber;

//    private List<Integer> address_ids; //todo: address tablosu ile bağlantısı sağlanacak manager tarafında

//    @NotNull
    @Size(min = 11, max = 11)
    private String mobilePhoneNumber;

//    @NotNull
    @Size(min = 11, max = 11)
    private String homePhoneNumber;

//    @NotNull
    @Size(min = 2, max = 30)
    private String password;
}
