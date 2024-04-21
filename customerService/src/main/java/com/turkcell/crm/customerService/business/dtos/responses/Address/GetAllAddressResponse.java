package com.turkcell.crm.customerService.business.dtos.responses.Address;

import com.turkcell.crm.customerService.core.enums.AddressType;
import com.turkcell.crm.customerService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllAddressResponse {
    private String city;

    private String district;

    private String street;

    private String addressDetail;

    private String postalCode;

    private AddressType addressType;

    private String addressTitle;

    private Customer customer;
}
