package com.turkcell.crm.accountService.accountService.business.dtos.requests.Account;

import com.turkcell.crm.accountService.accountService.core.enums.AccountType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAccountRequest {

    @NotNull
    @Size(min = 2, max = 30)
    private String accountName;

    @NotNull
    private AccountType accountType;

    @NotNull
    private int customerId;
}
