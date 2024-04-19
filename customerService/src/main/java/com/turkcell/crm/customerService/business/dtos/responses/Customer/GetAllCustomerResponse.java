package com.turkcell.crm.customerService.business.dtos.responses.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCustomerResponse {
    private int id;
    private String name;
}
