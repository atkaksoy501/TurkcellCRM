package com.turkcell.crm.common.events.identity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateIndividualCustomerEvent {
    private int id;

    private String email;

    private String firstName;

    private String lastName;

    private String nationalityId;

    private String mobilePhoneNumber;

    private String accountNumber;

    private String orderNumber;
}
