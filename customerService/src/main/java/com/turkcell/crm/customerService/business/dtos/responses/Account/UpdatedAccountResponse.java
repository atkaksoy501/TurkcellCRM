package com.turkcell.crm.customerService.business.dtos.responses.Account;

import com.turkcell.crm.customerService.core.enums.AccountStatus;
import com.turkcell.crm.customerService.core.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedAccountResponse {
    private AccountStatus status;

    private String accountNumber;

    private String accountName;

    private AccountType accountType;

    private LocalDateTime updatedDate;
}
