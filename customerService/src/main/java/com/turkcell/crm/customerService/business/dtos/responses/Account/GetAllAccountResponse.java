package com.turkcell.crm.customerService.business.dtos.responses.Account;

import com.turkcell.crm.customerService.core.enums.AccountStatus;
import com.turkcell.crm.customerService.core.enums.AccountType;
import com.turkcell.crm.customerService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllAccountResponse {
    private AccountStatus status;

    private String accountNumber;

    private String accountName;

    private AccountType accountType;

    private Customer customer;
}
