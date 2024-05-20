package com.turkcell.crm.customerService.business.dtos.requests.Address;

import com.turkcell.crm.customerService.entities.concretes.enums.AddressType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressRequest {
    @NotNull
    @Size(min = 2, max = 30)
    private String city;

    @NotNull
    @Size(min = 2, max = 30)
    private String district;

    @NotNull
    @Size(min = 2, max = 30)
    private String street;

    @NotNull
    @Size(min = 2, max = 100)
    private String addressDetail;

    @NotNull
    @Size(min = 5, max = 5)
    private String postalCode;

    @NotNull
    private AddressType addressType;

    @NotNull
    @Size(min = 2, max = 15)
    private String addressTitle;

    @NotNull
    private int customerId;
}
