package com.turkcell.crm.accountService.accountService.business.dtos.responses.Account;

import com.turkcell.crm.accountService.accountService.core.enums.AccountStatus;
import com.turkcell.crm.accountService.accountService.core.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAccountResponseById {
    private AccountStatus status;

    private String accountNumber;

    private String accountName;

    private AccountType accountType;

    private int customerId;
}
