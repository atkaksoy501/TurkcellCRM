package com.turkcell.crm.accountService.accountService.business.dtos.responses.Account;

import com.turkcell.crm.accountService.accountService.core.enums.AccountStatus;
import com.turkcell.crm.accountService.accountService.core.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedAccountResponse {

    private AccountStatus status;

    private String accountNumber;

    private String accountName;

    private AccountType accountType;

    private LocalDateTime createdDate;

    private List<Integer> productIds;
}
