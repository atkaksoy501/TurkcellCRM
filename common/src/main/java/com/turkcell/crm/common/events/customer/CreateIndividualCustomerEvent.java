package com.turkcell.crm.common.events.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateIndividualCustomerEvent {
    private int id;

    private String email;

    private String firstName;

    private String lastName;

    private String nationalityNumber;

    private String mobilePhoneNumber;

    private String accountNumber;

    private String orderNumber;
}
