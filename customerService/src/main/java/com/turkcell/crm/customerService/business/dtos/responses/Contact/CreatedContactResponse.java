package com.turkcell.crm.customerService.business.dtos.responses.Contact;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedContactResponse {
    private String mobilePhoneNumber;

    private String homePhoneNumber;

    private String workPhoneNumber;

    private String faxNumber;

    private String email;

    private LocalDateTime createdDate;
}
