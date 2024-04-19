package com.turkcell.crm.customerService.business.dtos.requests.Customer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerRequest {
    @NotNull
    private int id;

    @NotNull
    private CreateCustomerRequest updatedCustomer;
}
