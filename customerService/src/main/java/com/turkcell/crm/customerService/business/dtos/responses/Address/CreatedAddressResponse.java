package com.turkcell.crm.customerService.business.dtos.responses.Address;

import com.turkcell.crm.customerService.core.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedAddressResponse {
    private String city;

    private String district;

    private String street;

    private String addressDetail;

    private String postalCode;

    private AddressType addressType;

    private String addressTitle;

    private LocalDateTime createdDate;
}
