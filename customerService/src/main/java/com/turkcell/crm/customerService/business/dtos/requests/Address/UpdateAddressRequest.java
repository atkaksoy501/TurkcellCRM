package com.turkcell.crm.customerService.business.dtos.requests.Address;

import com.turkcell.crm.customerService.core.enums.AddressType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAddressRequest {
    @NotNull
    private int id;

    @Size(min = 2, max = 30)
    private String city;

    @Size(min = 2, max = 30)
    private String district;

    @Size(min = 2, max = 30)
    private String street;

    @Size(min = 2, max = 100)
    private String addressDetail;

    @Size(min = 5, max = 5)
    private String postalCode;

    private AddressType addressType;

    @Size(min = 2, max = 15)
    private String addressTitle;
}
