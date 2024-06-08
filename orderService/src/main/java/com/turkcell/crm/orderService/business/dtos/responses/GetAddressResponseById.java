package com.turkcell.crm.orderService.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAddressResponseById {

    private String city;

    private String district;

    private String street;

    private String addressDetail;

    private String postalCode;

}
