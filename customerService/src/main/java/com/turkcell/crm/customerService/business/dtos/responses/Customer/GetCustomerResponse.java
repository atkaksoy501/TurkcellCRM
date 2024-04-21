package com.turkcell.crm.customerService.business.dtos.responses.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCustomerResponse { //getAll ve getById dışında kullanılan alanlar için
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
}
