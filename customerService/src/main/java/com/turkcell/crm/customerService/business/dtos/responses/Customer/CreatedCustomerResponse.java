package com.turkcell.crm.customerService.business.dtos.responses.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedCustomerResponse {
    private int id;
    private String name;
    private LocalDateTime createDate;
}
