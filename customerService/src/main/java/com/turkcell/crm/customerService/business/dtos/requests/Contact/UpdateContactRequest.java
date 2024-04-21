package com.turkcell.crm.customerService.business.dtos.requests.Contact;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateContactRequest {
    @NotNull
    private int id;

    @Size(min = 11, max = 11)
    private String mobilePhoneNumber;

    @Size(min = 11, max = 11)
    private String homePhoneNumber;

    @Size(min = 11, max = 11)
    private String workPhoneNumber;

    @Size(min = 11, max = 11)
    private String faxNumber;

    @Size(min = 2, max = 50)
    private String email;
}
