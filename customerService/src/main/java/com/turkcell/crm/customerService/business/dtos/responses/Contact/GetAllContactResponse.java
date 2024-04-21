package com.turkcell.crm.customerService.business.dtos.responses.Contact;

import com.turkcell.crm.customerService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllContactResponse {
    private String mobilePhoneNumber;

    private String homePhoneNumber;

    private String workPhoneNumber;

    private String faxNumber;

    private String email;

    private Customer customer;
}
