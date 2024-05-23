package com.turkcell.crm.common.events.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateIndividualCustomerEvent {
    private int id;

    private String email;

    private String firstName;

    private String middleName;

    private String lastName;

    private String nationalityNumber;

    private String mobilePhoneNumber;

    private List<String> accountNumbers;

    private String orderNumber;
}
