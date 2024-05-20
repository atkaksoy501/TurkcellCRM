package com.turkcell.crm.customerService.business.dtos.responses.Address;

import com.turkcell.crm.customerService.entities.concretes.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedAddressResponse {
    private String city;

    private String district;

    private String street;

    private String addressDetail;

    private String postalCode;

    private AddressType addressType;

    private String addressTitle;

    private LocalDateTime updatedDate;
}
