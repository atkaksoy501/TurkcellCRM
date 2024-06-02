package com.turkcell.crm.customerService.business.dtos.requests.Address;

import com.turkcell.crm.customerService.entities.concretes.enums.AddressType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressRequest {
    @NotEmpty
    @Size(min = 2, max = 30)
    private String city;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String district;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String street;

    @NotEmpty
    @Size(min=2,max=30)
    private String doorNumber;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String addressDetail;

    @NotEmpty
    @Size(min = 5, max = 5)
    private String postalCode;

    @NotEmpty
    private AddressType addressType;

    @NotEmpty
    @Size(min = 2, max = 15)
    private String addressTitle;

    @NotEmpty
    private int customerId;
}
