package com.turkcell.crm.customerService.business.dtos.requests.Customer;

import com.turkcell.crm.customerService.core.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateIndividualCustomerRequest {
    private String firstName;

    private String email;

    private String middleName;

    private String lastName;

    private LocalDate birthDate;

//    private Gender gender; //todo: enum tablosu olacak

    private String fatherName;

    private String motherName;

    private String motherMaidenName;

    private String nationalityId;

//    private List<Integer> address_ids; //todo: address tablosu ile bağlantısı sağlanacak manager tarafında

    private String mobilePhoneNumber;

    private String homePhoneNumber;
}
